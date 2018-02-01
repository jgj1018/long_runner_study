package stream

class DataBuffer {
    var buffer:CharArray = CharArray(4)
    var offset = 0
    var pos = 0


    fun isBufferEmpty():Boolean{
       val result =  buffer.filterNot { c: Char -> c =='\u0000'  }
       return result.isEmpty()
    }


    fun isPosReachToEnd():Boolean{
        return pos == (buffer.lastIndex + 1)
    }


    fun reNewBuffer(){
        this.buffer = CharArray(4)
        this.pos = 0

    }

    fun getSingleData():Char{
        val text = this.buffer.get(this.pos++)
        return text
    }
}