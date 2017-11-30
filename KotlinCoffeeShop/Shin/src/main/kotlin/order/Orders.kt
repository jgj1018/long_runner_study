package order

import menu.Menu
import shop.staff.OrderListener
import kotlin.properties.Delegates

interface Order {
    val menu: Menu

    override fun toString(): String
}

class StandardOrder(override val menu:Menu): Order {
    override fun toString(): String {
        return "$menu"
    }
}

object OrderManager {
    private var orderListener: OrderListener? = null
    var orderList : MutableList<Order> by Delegates.observable(mutableListOf<Order>()) { _, _, new ->
        orderListener?.onOrderChanged(new)
    }

    fun addOrder(order:Order) {
        orderList.add(order)
        orderList = orderList.toMutableList()
    }

    fun removeFirstOrder() {
        orderList.removeAt(0)
    }

    fun updateListener(newListener: OrderListener) {
        this.orderListener = newListener
    }
}