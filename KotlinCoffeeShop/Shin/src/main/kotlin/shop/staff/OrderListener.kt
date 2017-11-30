package shop.staff

import order.Order

interface OrderListener {
    fun onOrderChanged(orderListUpdated: MutableList<Order>)
}