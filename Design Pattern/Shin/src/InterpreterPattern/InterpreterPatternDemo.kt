package InterpreterPattern

import InterpreterPattern.expression.*

fun main(args: Array<String>) {
    val isMale = getMaleExpression()
    val isMarriedWoman = getMarriedWomanExpression()

    println("John is male? ${isMale.interpret("John")}")
    println("Julie is married women? ${isMarriedWoman.interpret("Married Julie")}")
}

/**
 * Rule : Robert and John are male
 */
fun getMaleExpression():Expression {
    val robert: Expression = TerminalExpression("Robert")
    val john: Expression = TerminalExpression("John")

    return OrExpression(robert, john)
}

/**
 * Rule : Julie is a married women
 */
fun getMarriedWomanExpression():Expression {
    val julie = TerminalExpression("Julie")
    val married = TerminalExpression("Married")

    return AndExpression(julie, married)
}