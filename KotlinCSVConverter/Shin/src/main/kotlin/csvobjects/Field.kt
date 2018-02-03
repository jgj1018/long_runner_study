package csvobjects

/**
 * 칸
 */
class Field(rawValue: String?) {
    var isString: Boolean = false
    var value = ""
    init {
        if (rawValue == null) {
            rawValue == ""
        } else {
            if (rawValue.contains("\"")) {
                isString = true
            }

            if (isString) {

                val firstIndex = rawValue.indexOfFirst { it == '\"' }
                val lastIndex = rawValue.indexOfLast { it == '\"' }
                value = rawValue.substring(firstIndex + 1, lastIndex)
            }
        }
    }

    override fun toString(): String {
        return value
    }
}