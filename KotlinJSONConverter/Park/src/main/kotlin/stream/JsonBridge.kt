package stream

import com.sun.org.apache.xpath.internal.operations.Bool
import internal.DataQueue
import internal.TypeAdapter
import internal.TypeAdapterBridge
import java.util.*

class JsonBridge:TypeAdapter {

    val jsonKV:KVAdapter<String, TypeAdapter> = KVAdapter()
    private lateinit var dest:String
    private var jReader:JsonReader
    private val bracketStack:Stack<Char> = Stack()
    private val quoteStack:Stack<Char> = Stack()
    private val keyDataQueue:DataQueue<Char> = DataQueue()
    private val valueDataQueue:DataQueue<Char> = DataQueue()
    private val keyStack:Stack<String> = Stack()
    private val valueStack:Stack<String> = Stack()
    private var ISVALUESTART = false
    private var subObj:JsonBridge? = null
    private var subBracket:Char? = null
    private var ISARRAYSTARTED = false
    constructor(dest:String){
        this.dest = dest
        jReader = JsonReader(dest)
    }


    constructor(reader: JsonReader, rawChar: Char){
        this.jReader = reader
        subBracket = rawChar
    }


    fun extractRawData(){
        var rawChar:Char = this.initRawChar()


        this.isValidFormat(rawChar)

        if (this.isObjectFormatStart(rawChar)) {
            bracketStack.push(rawChar)
            this.extractRawData()
            return
        }

        if (this.isSubObjectStart(rawChar)){
            this.doSubObjJob(rawChar)
            return
        }

        try {
            if (rawChar == '"' && !ISVALUESTART ) {
                keyStartAndClose(rawChar)
                return
            }

            if(this.doValueJob(rawChar)){
                return
            }

        }catch (e: NullPointerException){
           throw BadJsonFormatException()
        }

        if(this.isObjectEnd(rawChar)){
            this.bracketStack.pop()
            this.ISVALUESTART = false
            this.ISARRAYSTARTED = false
            val value = this.makeValue()
            if (rawChar == ']'){
                this.valueStack.push(value+rawChar)

            }else{
                this.valueStack.push(value)

            }
            setJsonKV()
            return
        }

        if(this.arrayStarted(rawChar)){
            this.ISARRAYSTARTED = true


        }
        this.insertRawData(rawChar)

    }

    private fun initRawChar():Char{
        var rawChar:Char
        if(subBracket != null){
            rawChar = this.subBracket!!
            subBracket = null
        }else{
            rawChar = this.jReader.getData()
        }
        return rawChar
    }


    private fun isValidFormat(text:Char):Boolean{
        if (text != '{' && bracketStack.empty()){
            throw BadJsonFormatException()
        }
        return true
    }


    private fun isObjectFormatStart(text: Char): Boolean {
        return text == '{' && quoteStack.empty() && bracketStack.empty()
    }


    private fun isSubObjectStart(text: Char):Boolean{
        return text == '{' && quoteStack.empty() && !bracketStack.empty()

    }


    private fun isObjectEnd(text: Char):Boolean{
        return text == '}' && (bracketStack.size == 1)
    }


    private fun keyStartAndClose(rawChar:Char){
        if (this.isKeyStart(rawChar)) {
            quoteStack.push(rawChar)
            this.extractRawData()
            return
        }

        if (this.isKeyClose(rawChar)) {
            quoteStack.pop()
            if (keyDataQueue.isNotEmpty()) {
                val key = this.makeKey()
                this.keyStack.push(key)
            }
            return
        } else {
            throw BadJsonFormatException()
        }
    }


    private fun isKeyStart(text: Char):Boolean{
        return text == '"' && !bracketStack.empty() && quoteStack.empty() && !ISVALUESTART
    }


    private fun isKeyClose(text: Char):Boolean{
        return text == '"' && !bracketStack.empty() && !quoteStack.empty() && !ISVALUESTART
    }

    private fun doValueJob(rawChar: Char):Boolean{
        if(this.isValueStart(rawChar)){
            this.ISVALUESTART = true
            this.extractRawData()
            return true
        }
        if (ISARRAYSTARTED && rawChar == ']' && ISVALUESTART){
            this.ISVALUESTART = false
            this.ISARRAYSTARTED = false
            val value = this.makeValue()
            this.valueStack.push(value+rawChar)
            setJsonKV()
            return true

        }

        else if (this.isValueEnd(rawChar)){
            this.ISVALUESTART = false
            val value = this.makeValue()
            this.valueStack.push(value)
            setJsonKV()

            return true
        }


        return false
    }

    private fun isValueStart(text: Char):Boolean{
        return text == ':' && quoteStack.empty() && !bracketStack.empty()
    }

    private fun isValueEnd(text: Char):Boolean{
        if(this.allStackEmpty()) return false
        return (text == ',' && quoteStack.empty())  && !ISARRAYSTARTED && ISVALUESTART

    }

    private fun allStackEmpty():Boolean{
        return this.valueStack.empty() && keyStack.empty()
    }


    private fun setJsonKV(){

        this.jsonKV.put(this.keyStack.pop(), TypeAdapterBridge(this.valueStack.pop()))
    }


    private fun arrayStarted(rawChar: Char):Boolean{
        return ISVALUESTART && rawChar == '['
    }


    private fun insertRawData(rawChar: Char){
        if(isCharSpecial(rawChar) && quoteStack.empty() && !ISVALUESTART) return

        if (ISVALUESTART){
            this.valueDataQueue.offer(rawChar)
        }else{
            this.keyDataQueue.offer(rawChar)

        }

    }

    private fun isCharSpecial(rawChar: Char):Boolean{
        return rawChar == ','
    }

    private fun makeKey():String{
        return keyDataQueue.extractData()!!
    }


    private fun makeValue():String{
        return valueDataQueue.extractData()!!
    }


    fun makeKeyandValue(){
        try {
            while(true){
                this.extractRawData()
            }
        }catch (e:ReachToEOFException){
        }finally {
            return
        }
    }

    private fun doSubObjJob(rawChar: Char){
        subObj =JsonBridge(jReader, rawChar)
        subObj!!.makeKeyandValue()
        this.jReader = subObj!!.passReader()
        this.jsonKV.put(this.keyStack.pop(), this.subObj!!.jsonKV)
        subObj = null
        this.ISVALUESTART = false
    }

    fun passReader():JsonReader{
        return this.jReader
    }


}