package interpret.concrete

import interpret.Api.Expression

class TerminalExpression(private val data: String): Expression {

    override fun interpret(context: String):Boolean {
        return (context.contains(data))
    }
}