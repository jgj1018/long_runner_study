import menu.Menu
import order.Order
import shop.Shop
import shop.staff.CounterStaff

/**
 * 손님
 * 할 주문을 정하기
 * 주문하기
 * 돈 내기
 * 음료 받기
 */
class Customer {
    var order:Order? = null

    fun decideOrder(order: Order) {
        this.order = order
    }

    fun sayOrder(counterStaff: CounterStaff) {
        customerSay("${order?.menu}, please")
        counterStaff.getOrder(order)
    }

    fun payPriceOfOrder(counterStaff: CounterStaff) {
        customerSay("here is ${order?.menu?.price}")
        counterStaff.getMoney(order?.menu?.price ?: 0.0)
    }

    fun getBeverage(menu:Menu?):Boolean {
        if (order?.menu == menu) {
            customerSay("Thank you!")
            return true
        }
        return false
    }

    private fun customerSay(string:String) {
        println("** Customer says \"${string}\" **")
    }
}