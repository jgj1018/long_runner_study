import exception.InvalidJsonException
import json.JsonName
import json.JsonObject
import json.JsonToken
import json.PreJsonObject

class Parser2 {

    fun parse(string: String) {
        var returns = parseName(string)

        parseValue(returns)
    }

    fun parseName(string: String, state:ParsingState? = null):PreJsonObject {
        var parsingState = state
        if (parsingState == null) {
            parsingState = ParsingState.PRE_START
        }

        var stringStarted = false;
        var startIndex = 0
        var endIndex = 0

        for ((index, char) in string.withIndex()) {
            println(parsingState)
            // root { 를 찾는다.
            if (parsingState == ParsingState.PRE_START) {
                println("Pre_start")
                if (char.isBlank()) {
                    continue
                }

                if (char == JsonToken.LEFT_BRACE) {
                    parsingState = ParsingState.START
                }

                if (index == string.lastIndex) {
                    throw InvalidJsonException("Invalid Json Format")
                }
            }

            // 파싱 시작
            if (parsingState == ParsingState.START) {
                // Blank 무시
                if (char.isBlank()) {
                    continue
                }

                if (char == JsonToken.DOUBLE_QUOTATION) {
                    parsingState = ParsingState.NAME
                    continue
                }
            }

            //---------------------------------------------------------

            if (parsingState == ParsingState.NAME) {
                // name은 모두 string임
                if (!stringStarted) {
                    startIndex = index
                    stringStarted = true
                }

                if (char == JsonToken.DOUBLE_QUOTATION) {
                    endIndex = index

                    parsingState = ParsingState.NAME_END
                    break
                }
            }

        }

        val jsonName = JsonName(string.substring(startIndex, endIndex))
        val other = string.substring(endIndex + 1)

        return PreJsonObject(jsonName, other)
    }

    fun parseValue(preJsonObject: PreJsonObject) {
        var string = preJsonObject.other;

        var parsingState = ParsingState.NAME_END

        for ((char, index) in string.withIndex()) {

        }
    }

    /**
     * 공백, 줄바꿈, 탭문자인지 확인
     */
    fun Char.isBlank():Boolean {
        return this == ' ' || this == '\n' || this == '\t'
    }
}