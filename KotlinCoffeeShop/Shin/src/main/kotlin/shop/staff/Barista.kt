package shop.staff

import order.Order
import Customer
import order.OrderManager

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
        println("Now Making ${orderInProgress?.menu?.menuName}...")
    }

    fun passBeverageToCustomer(customer: Customer) {
        println("Here is ${orderInProgress?.menu?.menuName}")
        if (customer.getBeverage(orderInProgress?.menu)) {
            println("Your Welcome")
            orderInProgress = null
            deleteCompleteOrderFromOrderList()
        }
    }

    private fun deleteCompleteOrderFromOrderList() {
        OrderManager.removeFirstOrder()
    }

    private fun changeStateToIdle() {
        orderInProgress = null
    }

    private fun isIdle():Boolean {
        return orderInProgress == null
    }

    override fun onOrderChanged(orderListUpdated: MutableList<Order>) {
        takeOrder(orderListUpdated.first())
    }
}