import csvobjects.CSVObject
import csvobjects.Record
import java.io.File

class Parser {


    fun makeObject(rawString: String):CSVObject {
        val list = makeRecordList(rawString)
        println("Size: ${list.size}")
        list.forEach {
            println("$it")
        }
        return CSVObject(rawString, list)
    }

    fun makeRecordList(rawString: String): MutableList<Record> {
        var doubleQuotationCount = 0;
        var state = "START"
        var indexOfEscapedDoubleQuotation = 0;

        var escapedDoubleQuotation = false;

        var lineStartIndexList = mutableListOf<Int>()
        lineStartIndexList.add(0)

        for ((index, char) in rawString.withIndex()) {
            println("$index($char): $state")

            if (state != "DQ" && char == CSVToken.DOUBLE_QUOTATION) {
                state = "DQ"
                continue;
            }

            if (state == "DQ") {
                // 쌍따옴표 이스케이프
                if (!escapedDoubleQuotation) {
                    if (char == CSVToken.DOUBLE_QUOTATION && rawString[index + 1] == CSVToken.DOUBLE_QUOTATION) {
                        escapedDoubleQuotation = true
                        continue;
                    }
                }

                if (escapedDoubleQuotation) {
                    println("Escape")
                    escapedDoubleQuotation = false
                    continue;
                }

                if (char == CSVToken.DOUBLE_QUOTATION) {
                    println("DQIndex: $index")
                    state = "NDQ"
                }
            } else {

                val lineIndex = getLineSeparatorIndex(char, index, rawString)
                println("Index: $index")
                if (lineIndex == -1) {
                    continue
                } else {
                    println("lineIndex: $lineIndex")
                    lineStartIndexList.add(lineIndex)
                }
            }
        }

        val recordList = mutableListOf<Record>()
        println(lineStartIndexList)

        lineStartIndexList.withIndex().forEach {
            var rawLine = ""
            rawLine = when {
                it.index == 0 -> rawString.substring(0, lineStartIndexList[it.index + 1])
                it.index != lineStartIndexList.lastIndex -> //println("${it.index}: ${it.value} ")
                    rawString.substring(it.value + 1, lineStartIndexList[it.index + 1])
                else -> rawString.substring(lineStartIndexList[it.index] + 1)
            }
            println(rawLine)
            recordList.add(Record(rawLine))
        }

        return recordList
    }

    private fun getLineSeparatorIndex(char: Char, recentIndex: Int, rawString: String):Int {
        if (char == '\r') {
            if (rawString[recentIndex + 1] == '\n') {
                return recentIndex + 1
            }
            return recentIndex
        }

        if (char == '\n') {
            if (rawString[recentIndex - 1] != '\r') {
                return recentIndex
            }
        }

        return -1
    }
}