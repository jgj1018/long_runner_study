package InterpreterPattern.expression

class TerminalExpression(private val data:String):Expression {
    override fun interpret(context: String):Boolean = context.contains(data)
}