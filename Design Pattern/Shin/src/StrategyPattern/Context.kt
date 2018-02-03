package StrategyPattern

import StrategyPattern.strategy.Strategy

class Context(val strategy: Strategy) {
    fun executeStrategy(num1: Int, num2: Int):Int = strategy.doOperation(num1, num2)
}