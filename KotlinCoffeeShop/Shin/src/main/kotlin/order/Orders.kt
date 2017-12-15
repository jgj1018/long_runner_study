package order

import menu.Menu
import menu.MenuCategory
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
    /**
     * Kotlin 옵저버 패턴
     * 주의 : List는 요소가 추가된다고 해서 바뀌는건 아님
     */
    private var orderList : MutableList<Order> by Delegates.observable(mutableListOf<Order>()) { _, _, new ->
        orderListener?.onOrderChanged(new)
    }

    fun addOrder(order:Order) {
        orderList.add(order)
        orderList = orderList.toMutableList()
    }

    fun removeFirstOrder(category: MenuCategory) {
        orderList.remove(this.orderList.first { it.menu.category == category })
        orderList = orderList.toMutableList()
    }

    fun updateListener(newListener: OrderListener) {
        this.orderListener = newListener
    }
}