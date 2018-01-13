package interpret.Api

interface Expression {
    fun interpret(context: String): Boolean
}