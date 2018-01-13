package stream

import java.io.FileReader

class JsonReader( dest:String){

    private val fileReader:FileReader
    private var isQuoted = false
    private val dataBuffer = DataBuffer()
    private var EOF = 0
    private var isSingleComment = false
    private var isMultiLineComment = false
    private var escaped = false
    init {
        val fileReader = FileReader(dest)
        this.fileReader = fileReader

    }


    fun getData():Char{
        val text =this.getValidChar()
        this.changeEscapeStatus(text)
        this.changeQuoteStatus(text)

        return text
    }


    private fun getValidChar():Char{
        var text = this.getChar()


        if(isSingleComment || isMultiLineComment){
            text = this.getNonCommentChar()
        }


        if(isNonValidSpace(text)){
            text = this.getValidChar()
        }


        try{
            if (!isComment(text)){}
            else{
                text = this.getValidChar()
            }



        }catch (e: BadJsonFormatException){

        }

        return text
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




    private fun isNonValidSpace(text: Char):Boolean{

        if(!isQuoted && isEnterOrWhiteSpace(text)){
            return true
        }

        return false
    }


    private fun isEnterOrWhiteSpace(text:Char):Boolean{
        if(text == '\n' || text == ' ' || text == ' '){
            return true
        }

        return false
    }

    /**
     * If AnyCharacter but '/' and '*' appear at out of Quote
     * Throw @exception BadJsonFormatException
     * */
    private fun isComment(text:Char):Boolean = if( text == '/' && !isQuoted){
        val nextText = this.getChar()

        when(nextText){

            '/' -> isSingleComment = true

            '*' -> isMultiLineComment = true

            else -> throw BadJsonFormatException()
        }

        true

    }else{
        false
    }


    private fun changeQuoteStatus(char: Char){
        if(char=='"'){
            if(!escaped && !isQuoted){
                isQuoted = true
            }
            else if(!escaped && isQuoted){
                isQuoted = false
            }

        }
    }

    private fun changeEscapeStatus(char: Char){
        if(char == '\\'){
            escaped = !escaped
        }
    }

    private fun getNonCommentChar():Char{
        val rawText:Char
        if(isSingleComment){
            rawText = this.skipToNextLine()
            isSingleComment = false

        }else{
            val firstChar = this.getChar()
            val secondChar = this.getChar()
            rawText = this.skipToNonMultiLineComment(firstChar, secondChar)
            isMultiLineComment = false

        }

        return rawText
    }

    private fun skipToNextLine(): Char {
        var enterChar: Char
        do {
            enterChar = this.getChar()
        }while(enterChar != '\n')
        return this.getChar()
    }

    /**
     * @keyword tailrec represents tailRecursive
    * */
    tailrec private fun skipToNonMultiLineComment(firstChar:Char, secondChar: Char):Char{
        return if(firstChar == '*' && secondChar == '/'){
            this.getChar()
        }else{
            this.skipToNonMultiLineComment(secondChar, this.getChar())
        }
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