package CommandPattern.order

import CommandPattern.Stock

interface Order {
    fun execute()
}

class BuyStock(private val abcStock: Stock):Order {
    override fun execute() {
        abcStock.buy()
    }
}

class SellStock(private val abcStock: Stock):Order {
    override fun execute() {
        abcStock.sell()
    }
}