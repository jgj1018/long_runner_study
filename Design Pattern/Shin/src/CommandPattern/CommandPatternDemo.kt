package CommandPattern

import CommandPattern.order.BuyStock
import CommandPattern.order.Order
import CommandPattern.order.SellStock

fun main(args: Array<String>) {
    val abcStock = Stock()

    val buyStockOrder = BuyStock(abcStock)
    val sellStockOrder = SellStock(abcStock)

    val broker = Broker()
    broker.takeOrder(buyStockOrder)
    broker.takeOrder(sellStockOrder)

    broker.placeOrders()
}

class Stock() {
    private val name:String = "ABC"
    private val quantity:Int = 10

    fun buy() {
        println("Stock [ Name: $name, Quantity: $quantity ] bought")
    }

    fun sell() {
        println("Stock [ Name: $name, Quantity: $quantity ] sold")
    }
}

class Broker {
    private val orderList = mutableListOf<Order>()

    fun takeOrder(order: Order) {
        orderList.add(order)
    }

    fun placeOrders() {
        orderList.forEach {
            it.execute()
        }
        orderList.clear()
    }
}