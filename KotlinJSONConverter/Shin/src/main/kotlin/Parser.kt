import exception.InvalidJsonException
import json.JsonRootObject
import json.JsonToken

/**
 * String을 파싱해서 트리로 만든다.
 */
class Parser {
    val buffer = mutableListOf<Char>()
    var state:ParsingState? = null
    //var jsonRoot = JsonRootObject()

    /**
     *
     */
    fun parse(stringedJson: String): JsonRootObject {

        return JsonRootObject()
    }

    private fun bufferToString():String {
        var string:String = ""
        buffer.forEach {
            string += it
        }

        return string
    }

    fun findNamePart(string: String):Array<Int> {
        /*
        전처리가 끝나서 공백, 개행, 탭, {}가 제거된 상태를 가정
         */

        var nameStartIndex = 0;
        var nameEndIndex = 0;
        var colonIndex = 0;
        var doubleQuoteCount = 0;

        for ((index, char) in string.withIndex()) {
            if (char == JsonToken.DOUBLE_QUOTATION && doubleQuoteCount == 0) {
                doubleQuoteCount++;
                continue
            }

            if (char == JsonToken.DOUBLE_QUOTATION && doubleQuoteCount == 1) {
                nameEndIndex = index - 1
                doubleQuoteCount++
                continue
            }

            if (doubleQuoteCount == 1 && nameStartIndex == 0) {
                nameStartIndex = index
            }

            if (doubleQuoteCount == 2) {
                if (char == JsonToken.COLON) {
                    colonIndex = index
                    break
                }
                if (char == JsonToken.DOUBLE_QUOTATION) {
                    throw InvalidJsonException("three or more DoubleQuotation in name part")
                }
            }
        }

        return arrayOf(nameStartIndex, nameEndIndex, colonIndex)
    }

    fun findValueType(string: String, colonIndex: Int):String {
        var valueType = ""
        var valuePart = string.substring(colonIndex).trim()

        val char = valuePart[0]

        when {
            char == JsonToken.DOUBLE_QUOTATION -> {
                if (validateValueStringType(valuePart)) {
                    valueType = "String"
                } else {
                    throw InvalidJsonException("invalid String value type")
                }
            }
            char == JsonToken.LEFT_BRACE        -> valueType = "Object"
            char == JsonToken.LEFT_BRACKET      -> valueType = "Array"
            valuePart.isNumeric()                 -> valueType = "Number"
            valuePart.substring(0, 4) == "true" -> valueType = "True"
            valuePart.substring(0, 4) == "null" -> valueType = "null"
            valuePart.substring(0, 5) == "false" -> valueType = "False"
        }

        return valueType
    }

    fun findValuePart(string:String, colonIndex:Int, valueType:String) {
        /*

         */
        var valuePart = string.substring(colonIndex + 1).trim()
        var doubleQuotationCount = 0


    }

    fun validateFirstDoubleQuotation(string: String):Boolean {
        return string.first() == JsonToken.DOUBLE_QUOTATION
    }

    /**
     * 공백 및 {} 제거
     */
    private fun preProcess(string: String):String {
        // 공백 제거
        var trimmedString = string.trim()

        // 첫자랑 마지막자가 {}인지 확인
        if (!validateFirstAndLastBrace(trimmedString)) {
            throw InvalidJsonException("1")
        }

        trimmedString = trimBrace(string)
        trimmedString = trimmedString.trim()

        // 첫자가 "인지 확인
        if (trimmedString.first() != JsonToken.DOUBLE_QUOTATION) {
            throw InvalidJsonException("2")
        }

        return trimmedString
    }

    /**
     *
     */
    fun validateFirstAndLastBrace(string: String):Boolean {
        return string.first() == JsonToken.LEFT_BRACE && string.last() == JsonToken.RIGHT_BRACE
    }

    /**
     * remove whitespace, linefeed, tab
     *
     * @param string
     * @return string
     */
    fun trimWhitespaceAndLineFeed(string: String):String {
        return string.trim('\n', ' ', '\t')
    }

    /**
     * 첫자랑 마지막자의 {} 제거
     * @param string:String
     * @return String
     */
    fun trimBrace(string: String):String {
        return string.trimStart(JsonToken.LEFT_BRACE).trimEnd(JsonToken.RIGHT_BRACE)
    }

    private fun String.isNumeric(): Boolean {
        return try {
            this.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun validateValueStringType(string: String):Boolean {
        return string.count { it == '"' } >= 2
    }

    private fun findStringValueIndexes(valuePart:String) {


        for ((index, char) in valuePart.withIndex()) {
            if (index == 0 && char == JsonToken.DOUBLE_QUOTATION) {

            }
        }
    }

    fun findSplitIndex(string: String): Int {
        /*
        두개의 쌍따옴표, 한개의 콜론, (두개의 쌍따옴표) , 쉼표 혹은 }

        */

        string.indexOfFirst { it == ',' }

        val doubleQuoteIndexList = string.withIndex().filter { it.value == '"' }.map { it -> it.index }
        val commaIndexList = string.withIndex().filter { it.value == ',' }.map { it -> it.index }
        val colonIndexList = string.withIndex().filter { it.value == ':' }.map { it -> it.index }

        /*
        첫번째 줄만 생각해보자
        1. 쉼표가 있는 경우
        2. 쉼표가 없는 경우

         */

        // 쉼표가 없는 경우를 생각해본다.
        // 쉼표가 전혀 없다는 것은, 이 Json형식은 단 하나의 name-value 쌍으로만 되어있다는 것을 뜻한다.
        // 그렇다면 콜론이 하나인 경우에는, 콜론을 중심으로 name-value쌍이 형성되어 있음을 뜻한다.
        // 콜론이 둘 이상인 경우에는, value 값이나 name값 안에 string이 들어있을 것이다.
        // 만약 colonIndex.first()가 DQIndex.second()보다도 전에 있다면, name에 들어있는 것이다.
        var firstNameValueSeparator = colonIndexList.first { it > doubleQuoteIndexList[1] }

        var firstValueChar = string.substring(firstNameValueSeparator + 1).trim().trim('\n').first()

        when(firstValueChar) {
            JsonToken.DOUBLE_QUOTATION -> {
                var dqIndex = string.indexOf('"', doubleQuoteIndexList[2])
                return commaIndexList.first { it > dqIndex }
            }
            // LEFT_BRACKET == [ / Json Array
            JsonToken.LEFT_BRACKET -> {

            }
            // LEFT_BRACE == {
            JsonToken.LEFT_BRACE -> {

            }
            else -> {

                return commaIndexList.first {
                    it > firstNameValueSeparator
                }
            }
        }

        if (firstValueChar == JsonToken.DOUBLE_QUOTATION) {

        }

        if (colonIndexList.first() < commaIndexList.first()) {

        }



        return 0
    }
}