package stream

import java.io.FileReader
import java.util.*

class CsvReader(dest:String){

    enum class Symbol(val rawValue:Char){
        COMMA(','),
        DOUBLEQUOTE('"'),
        WHITESPACE(' ')
    }
    private val fileReader:FileReader
    private val dataBuffer = DataBuffer()
    private var EOF = 0
    private val quoteStack:Stack<Char> = Stack()
    
    init {
        val fileReader = FileReader(dest)
        this.fileReader = fileReader

    }


   tailrec fun getData(accum:String = ""):String{

       var text:Char = '\u0000'
       try {
           text =this.getValidChar()

       }catch (e:ReachToEOFException){

       }finally {
           if(isEndOfValue(text)){
               return accum
           }
       }
       val passingAccum = buildPassingAccum(accum,text)

        return getData(passingAccum)
    }



    tailrec private fun getValidChar():Char{
        val text = this.getChar()
        return if (isValidChar(text)){
            text

        }else{
            getValidChar()
        }
    }


    private fun getChar():Char{
        this.filBuffer()
        val rawText:Char
        try{
            rawText = dataBuffer.getSingleData()

        }catch (e:IndexOutOfBoundsException){
            throw ReachToEOFException()
        }

        return rawText
    }

    private fun isValidChar(char:Char):Boolean{
        if(char.equals(Symbol.WHITESPACE.rawValue)){
            return this.quoteStack.size %2 != 0
        }
        return true
    }

    private fun buildPassingAccum(accum:String, text:Char):String{
        var passingAccum = accum

        if(this.isDoubleQuote(text)){
            quoteStack.push(text)

        }else{
            passingAccum += text
        }
        return passingAccum
    }
    
    private fun isDoubleQuote(char: Char):Boolean{
        if(char.equals(Symbol.DOUBLEQUOTE.rawValue)){
            return true
        }
        return false
    }

    private fun isEndOfValue(char: Char):Boolean{
        return (isComma(char) && (this.quoteStack.size % 2) == 0) || EOF == -1
    }

    
    private fun isComma(char: Char):Boolean{
        if(char.equals(Symbol.COMMA.rawValue)){
            return true
        }
        return false
        
    }




    private fun filBuffer(){
        when {
            EOF == -1 -> return
            dataBuffer.isBufferEmpty() -> EOF = this.storeBuffer()
            dataBuffer.isPosReachToEnd() -> {
                dataBuffer.reNewBuffer()
                EOF = this.storeBuffer()
            }
        }
        this.checkEOF()
    }




    private fun checkEOF(){
        if(EOF != this.dataBuffer.buffer.size){
            this.dataBuffer.buffer = this.dataBuffer.buffer.sliceArray(IntRange(0,EOF-1))

            EOF =  -1
        }

    }


    private fun storeBuffer():Int{

        return fileReader.read(dataBuffer.buffer,dataBuffer.offset, dataBuffer.buffer.size)
    }



}