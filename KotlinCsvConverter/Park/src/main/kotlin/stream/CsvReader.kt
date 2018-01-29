package stream

import java.io.FileReader
import java.util.*
import java.util.regex.Pattern

class CsvReader(dest:String){

    enum class Symbol(val rawValue:Char){
        COMMA(','),
        DOUBLEQUOTE('"'),
        WHITESPACE(' '),
        LINEFEED('\n')
    }
    private val fileReader:FileReader
    private val dataBuffer = DataBuffer()
    private var EOF = 0
    private val quoteStack:Stack<Char> = Stack()
    private var ISINNERQUOTE = false
    init {
        val fileReader = FileReader(dest)
        this.fileReader = fileReader

    }


   tailrec fun getData(accum:String = ""):String{

       if (isInnerQuote(accum)){
           ISINNERQUOTE = true
       }
       var text = '\u0000'
       var passingAccum:String

       try {

           text =this.getValidChar()

       }catch (e:ReachToEOFException){

       }finally {

           if(isEOF(accum)){
               throw ReachToEOFException()
           }
           if(isEndOfValue(text, accum)){
               quoteStack.clear()
               if(!isSpecialChar(text) || ISINNERQUOTE && !isStringEnd(accum)){
                   return removeLastDoubleQuote(buildPassingAccum(accum,text))
               }
               return removeLastDoubleQuote(accum)
           }

       }
       passingAccum = buildPassingAccum(accum,text)

       if (isDoubleQuote(text)){
           quoteStack.push(text)
       }


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
        if( isWhiteSpaceOrLineFeed(char)){
            if(this.quoteStack.size == 1) return true

            return !this.quoteStack.empty()
        }
        return true
    }


    private fun isWhiteSpaceOrLineFeed(char:Char):Boolean{
        return char.equals(Symbol.WHITESPACE.rawValue) || char.equals(Symbol.LINEFEED.rawValue)
    }


    private fun isSpecialChar(text: Char):Boolean{
        return Symbol.values().any { it.rawValue == text || text.equals('\u0000')}
    }

    private fun buildPassingAccum(accum:String, text:Char):String{
        var passingAccum = accum
        if( text != '\u0000'){
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


    private fun isEOF(accum: String):Boolean{
        if(this.EOF == -1 && accum == ""){
            return true
        }
        return false
    }

    private fun isEndOfValue(char: Char, accum: String):Boolean{
        if ( EOF == -1) return true
        if(char.equals(Symbol.COMMA.rawValue)){
            return this.quoteStack.size % 2 == 0 && isStringEnd(accum)
        }else if (char == Symbol.LINEFEED.rawValue){
            return isStringEnd(accum) && ISINNERQUOTE
        }
        else{
            return false
        }
    }





    private fun removeLastDoubleQuote(text:String):String{
        if(ISINNERQUOTE ){
            ISINNERQUOTE = !ISINNERQUOTE

            return text.substring(1,text.length-1)
        }
        return text
    }


    private fun isStringEnd(text: String):Boolean{
        if (text =="") return true
        if(isInnerQuote(text)|| text.indexOf("\"") == -1){
            return true
        }
        return false

    }


    private fun isInnerQuote(text: String):Boolean{
        return Pattern.compile("(\"+).+\\1").matcher(text).matches()
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