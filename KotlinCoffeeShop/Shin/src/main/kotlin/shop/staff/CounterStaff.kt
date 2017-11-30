package shop.staff

import menu.Espresso
import menu.menus
import order.Order
import order.OrderManager

class CounterStaff {
    private val orderManager = OrderManager
    private var orderInProgress:Order? = null

    fun sayWelcome() {
        println("Welcome to the Cafe")
    }

    fun sayMenu() {
        println("OurMenu is ...")
        menus.values().forEach { println(it.name) }
        println("(End Of Menu)")
    }

    fun getOrder(order: Order?):Boolean {
        if (isIdle()) {
            orderInProgress = order
            return true
        }
        return false
    }

    fun sayPrice() {
        println("Price is $${calculatePrice()}")
    }

    fun getMoney(customersPay:Double) {
        if (orderInProgress?.menu?.price == customersPay) {
            println("Thank you")
        }
    }

    fun inputOrder() {
        orderManager.addOrder(orderInProgress!!)
        changeStatusToIdle()
    }

    private fun changeStatusToIdle() {
        orderInProgress = null
    }

    private fun isIdle():Boolean {
        return orderInProgress == null
    }

    private fun calculatePrice():Double {
        val menu = orderInProgress?.menu

        return menu?.price ?: 0.0
    }

}