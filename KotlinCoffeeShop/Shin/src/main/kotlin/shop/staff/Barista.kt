package shop.staff

import order.Order
import Customer
import menu.MenuCategory
import order.OrderManager

/**
 * 주문을 확인하기
 * 주문을 만들기
 * 만든 음료를 내놓기
 */
class Barista:OrderListener {
    var orderInProgress :Order? = null

    private fun takeOrder(order: Order?):Boolean {
        if (isIdle()) {
            orderInProgress = order
            return true
        }
        return false
    }

    fun makeBeverage() {
        println(orderInProgress?.menu.toString())
    }

    fun passBeverageToCustomer(customer: Customer) {
        if (customer.getBeverage(orderInProgress?.menu)) {
            println("Your Welcome")
            orderInProgress = null
            deleteCompleteOrderFromOrderList()
        }
    }

    private fun deleteCompleteOrderFromOrderList() {
        OrderManager.removeFirstOrder(MenuCategory.Coffee)
    }

    private fun changeStateToIdle() {
        orderInProgress = null
    }

    private fun isIdle():Boolean {
        return orderInProgress == null
    }

    /**
     * 옵저버 패턴
     * @param orderListUpdated Orders의 OrderManager가 관리하는 주문 리스트
     */
    override fun onOrderChanged(orderListUpdated: MutableList<Order>) {
        if (orderListUpdated.isEmpty()) {
            return
        }

        if (!areThereCoffeeOrderIn(orderListUpdated)) return

        val firstCapableOrder = seekOldestCoffeeOrder(orderListUpdated) ?: return
        println("firstOrder: $firstCapableOrder")
        takeOrder(firstCapableOrder)
        makeBeverage()
        deleteCompleteOrderFromOrderList()
        changeStateToIdle()
    }

    private fun seekOldestCoffeeOrder(orderList: MutableList<Order>):Order? {
        if (orderList.isNotEmpty()) {
            return orderList.first { it.menu.category == MenuCategory.Coffee  }
        }
        return null
    }

    private fun areThereCoffeeOrderIn(orderList: MutableList<Order>):Boolean {
        return orderList.any { it.menu.category == MenuCategory.Coffee }
    }
}