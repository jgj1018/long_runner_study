package StrategyPattern.strategy

class OperationAdd():Strategy {
    override fun doOperation(num1: Int, num2: Int): Int = num1 + num2
}