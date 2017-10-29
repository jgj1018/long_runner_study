package builder.sentenceBuilder.impLevel

import builder.sentenceBuilder.apiLevel.Builder


class TextBuilder:Builder() {
    private val buffer:StringBuffer = StringBuffer()
    override fun makeTitle(title: String) {
        buffer.append("===================\n")
        buffer.append("$title \n")
        buffer.append("\n")
    }

    override fun makeString(str: String) {
        buffer.append("■ $str \n")
        buffer.append("\n")
    }

    override fun makeItems(items: Array<String>) {
        for (item:String in items){
            buffer.append("    @$item \n")
        }
        buffer.append("\n")
    }

    override fun close() {
        buffer.append("===================\n")
    }
    fun getResult():String{
        return buffer.toString()
    }
}