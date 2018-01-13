enum class ParsingState {
    PRE_START,
    START,
    NAME,
    NAME_END,
    VALUE,
    VALUE_END,
    VALUE_STRING,
    END
}