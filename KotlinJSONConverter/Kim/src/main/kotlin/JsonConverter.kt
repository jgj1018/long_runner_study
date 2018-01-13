
class JsonConverter(val originalJsonText: String)
{
    companion object {
        const val KEY = 0
        const val VALUE = 1
    }

    var sourceMap: MutableMap<String, Any> = mutableMapOf<String, Any>()
    var parentKeyStack: MutableList<String> = mutableListOf<String>()
    var bracketStack: MutableList<Char> = mutableListOf<Char>()

    var isLastSegment: Boolean = false
    var isContinue:Boolean = false
    var isArray:Boolean = false
    var isObj:Boolean = false

    var currentStatus: String = "First"
    var remainingJsonText: String = originalJsonText

    var textChunk: String = ""
    var commaIndex: Int = 0
    var key: String = ""
    var value: String = ""

    fun convertJsonToArray()
    {
        if (isJson()) {
            makeSourceArrayFromString()
        }
    }

    fun makeSourceArrayFromString()
    {
        remainingJsonText = remainingJsonText.substring(remainingJsonText.indexOfFirst { it == '"' }, remainingJsonText.lastIndex+1).trim()
        println("=================================")
        while (remainingJsonText.trim().isNotBlank()) {
            updateStatusBeforeSplit()
            setTextChunk()
            splitKeyAndValueFromTextChunk()
            updateStatusAfterSplit()
            if (this.isContinue) {
                println("~~~~~~~~~~~countinued~~~~~~~~~~~~")
            } else {
                when (checkType()) {
                    "String" -> println("(4)This value is String")
                    "Integer"-> println("(4)This value is Integer")
                    "Boolean"-> println("(4)This value is Boolean")
                }
            }
            println("(5)bracketStack: ${this.bracketStack}")
            println("(6)parentKeyStack: ${this.parentKeyStack}")
            println("=================================")
        }
    }

    fun updateStatusBeforeSplit()
    {
        if(bracketStack.isNotEmpty()) {
            var checkChar:Char = bracketStack.get(bracketStack.size-1)

            when (checkChar) {
                '{' -> {
                    currentStatus = "Object"
                    isObj = true
                }
                '[' -> {
                    currentStatus = "Array"
                    isArray = true
                }
                'N'  -> {
                    currentStatus = "Normal"
                }
            }
        }
        isLastSegment = !(remainingJsonText.contains(','))
        isContinue = false
    }

    fun setTextChunk()
    {
        if (isLastSegment) {
            commaIndex = 0
            textChunk = remainingJsonText.substring(0, remainingJsonText.lastIndex+1)
        } else {
            commaIndex = remainingJsonText.indexOf(',')
            textChunk = remainingJsonText.substring(0, this.commaIndex)
        }
    }

    fun splitKeyAndValueFromTextChunk()
    {
        println("(1)textChunk: ${this.textChunk}")
        if (isLastSegment) {
            if (textChunk.contains(":")) {
                var keyValue: List<String> = textChunk.split(":")
                key = keyValue.get(KEY).trim()
                value = keyValue.get(VALUE).trim()
            } else {
                value = textChunk.trim()
            }
        } else if (isArray) {
            value = textChunk.trim()
        } else {
            var keyValue: List<String> = textChunk.split(":")
            key = keyValue.get(KEY).trim()
            value = keyValue.get(VALUE).trim()
        }
    }

    fun updateStatusAfterSplit()
    {
        if (value.contains('[')) {
            commaIndex = remainingJsonText.indexOf('[')
            parentKeyStack.add(parentKeyStack.count(), key.trim('"'))
            bracketStack.add(bracketStack.count(), '[')
            isContinue = true
        }

        if (value.contains('{')) {
            commaIndex = remainingJsonText.indexOf('{')
            parentKeyStack.add(parentKeyStack.count(), key.trim('"'))
            bracketStack.add(bracketStack.count(), '{')
            isContinue = true
        }

        if (isArray && value.contains(']')) {
            value = value.replace(']', ' ').trim()
            bracketStack.removeAt(bracketStack.size-1)
            parentKeyStack.removeAt(parentKeyStack.size-1)
            isArray = false
            isContinue = true
        }

        if (isObj && value.contains('}')) {
            value = value.replace('}', ' ').trim()
            bracketStack.removeAt(bracketStack.size-1)
            parentKeyStack.removeAt(parentKeyStack.size-1)
            isObj = false
            isContinue = true
        }

        if (isLastSegment) {
            println("(7)Last value: $value")
            remainingJsonText = ""
            isContinue = false
            bracketStack.clear()
            parentKeyStack.clear()
        } else {
            remainingJsonText = remainingJsonText.substring(commaIndex+1, remainingJsonText.lastIndex+1).trim()
        }
        println("(2)key: ${this.key}")
        println("(3)value: ${this.value}")
    }

    /**
     * This method is to set type for each value based on Kotlin type.
     * Each Json data type will be converted as below
     *
     * Json   -> Kotlin
     * =================
     * Number -> Integer
     * String -> String
     * Object -> Object TODO
     * Array  -> Array TODO
     * Boolean-> Boolean
     * Null   -> Null TODO
     *
     */
    fun checkType(): String
    {
        val value: String = value
        if (value.isNotBlank() && value.first() == '"') {
            return "String"
        } else if (value.toIntOrNull() != null) {
            return "Integer"
        } else if (value.toBoolean()) {
            return "Boolean"
        }
        return ""
    }

    /**
     * TODO
     * This method checks two things.
     * (1) The number of curly brace have to be even number.
     * (2) The string have to be started and ended with curly brace.
     */
    fun isJson(): Boolean
    {
        return true
    }

    /**
     * TODO
     * This method is to check if any specific string contains backslash for escaping.
     */
    fun isEscaped()
    {

    }
}
