package interpret

import interpret.Api.Expression
import interpret.concrete.AndExpression
import interpret.concrete.OrExpression
import interpret.concrete.TerminalExpression

fun getMaleExpression():Expression{
    val robert = TerminalExpression("Robert")
    val john = TerminalExpression("John")
    return OrExpression(robert, john)
}

fun getMarriedWomanExpression():Expression{
    val robert = TerminalExpression("Julie")
    val john = TerminalExpression("Married")
    return AndExpression(robert, john)
}


fun main(args: Array<String>) {
    val isMals = getMaleExpression()
    val isMarriedWoman = getMarriedWomanExpression()

    println("John is male? ${isMals.interpret("John")}")
    println("Julie is a married woman? ${isMals.interpret("Julie")}")

}