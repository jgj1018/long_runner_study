package StrategyPattern.strategy

class OperationMultiply:Strategy {
    override fun doOperation(num1: Int, num2: Int): Int = num1 * num2
}