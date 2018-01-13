package InterpreterPattern.expression

interface Expression {
    fun interpret(context: String): Boolean
}