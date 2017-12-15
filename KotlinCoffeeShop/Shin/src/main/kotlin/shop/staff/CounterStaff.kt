package shop.staff

import order.Order
import order.OrderManager
import shop.POS
import shop.Shop

/**
 *  카운터 스태프
 *  주문받기
 *
 *  주문을 주문 관리자에 등록하기
 *
 */
class CounterStaff(var shop: Shop, var pos: POS) {
    private val orderManager = OrderManager
    private var orderInProgress:Order? = null

    fun sayWelcome() {
        println("Welcome to the Cafe")
    }

    fun sayMenu() {
        println("OurMenu is ...")
        shop.menuList.sayAllMenu()
        println("(End Of Menu)")
    }

    fun getOrder(order: Order?):Boolean {
        if (!isIdle()) {
            return false
        }
        if (order?.menu!!.canBeMade(shop.storage)) {
            orderInProgress = order
            return true
        }

        return false
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

    fun setPOS(pos: POS) {
        this.pos = pos
    }
}