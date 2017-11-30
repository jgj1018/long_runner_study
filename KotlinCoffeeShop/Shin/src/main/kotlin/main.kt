import order.OrderManager
import order.StandardOrder
import shop.Shop

fun main(args: Array<String>) {
    val shop = Shop()
    val counterStaff = shop.counterStaff
    val barista = shop.barista
    OrderManager.updateListener(barista)
    counterStaff.sayWelcome()
    counterStaff.sayMenu()

    val customer = Customer()
    customer.decideOrder(StandardOrder(menu.Espresso()))
    customer.sayOrder(counterStaff)

    counterStaff.sayPrice()
    customer.payPriceOfOrder(counterStaff)

    counterStaff.inputOrder()

    barista.makeBeverage()
    barista.passBeverageToCustomer(customer)
}