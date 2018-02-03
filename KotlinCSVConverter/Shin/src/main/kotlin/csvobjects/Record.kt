package csvobjects

/**
 * 행
 */
class Record(private val rawLine: String, private val fieldList: MutableList<Field> = mutableListOf()) {
    init {
        println("rawLine: $rawLine")
        parseRecordToField()
    }

    override fun toString(): String {
        return rawLine
    }

    private fun addField(string: String?) {
        println("string: $string")
        val field = Field(string)
        println("field: $field")
        if (field == null) {
            println("field null")
        }
        fieldList.add(field)
    }

    fun parseRecordToField() {
        val pair = sliceFirstField(rawLine)
        fieldList.add(Field(pair.first))
        //addField(pair.first)
        var nextString = pair.second
        while (nextString != "") {
            val whilePair = sliceFirstField(nextString)
            addField(whilePair.first)
            nextString = whilePair.second
        }
    }

    private fun sliceFirstField(rawString: String): Pair<String, String> {

        if (rawString.count { it == CSVToken.DOUBLE_QUOTATION }.isOdd()) {
            throw Exception()
        }

        val commaIndexes = rawString.withIndex().filter { it.value == CSVToken.COMMA }.map { it -> it.index }
        val doubleQuotationIndexes = rawString.withIndex().filter { it.value == CSVToken.DOUBLE_QUOTATION }.map { it -> it.index }
        println("commaIndexes: $commaIndexes")
        println("doubleQuotationIndexes: $doubleQuotationIndexes")

        if (commaIndexes.isEmpty()) {
            return Pair(rawString, "")
        }

        return if (doubleQuotationIndexes.isEmpty() || commaIndexes.first() < doubleQuotationIndexes.first()) {
            Pair(rawString.substring(0, commaIndexes.first()), rawString.substring(commaIndexes.first() + 1))
        } else {
            commaIndexes
                    .asSequence()
                    .filterIndexed { index, position ->
                        index != 0 && rawString.substring(0, position).count { it == CSVToken.DOUBLE_QUOTATION }.isEven() }
                    .firstOrNull()
                    ?.let { Pair(rawString.substring(0, it), rawString.substring(it + 1)) }
                    ?: Pair("", "")
        }
    }

    private fun Int.isOdd(): Boolean = this % 2 == 1
    private fun Int.isEven(): Boolean = this % 2 == 0
}