import Menu.*
import Shop.*

fun main(args: Array<String>) {

    val test_shop: Shop = Shop(shop_id = "s001")
    test_shop.fetchMenuList(test_shop.shop_id)
    test_shop.showMenuList()
    println("Customer: One Americano please")
    val test_menu = test_shop.takeOrder(Beverage.Americano.value, 250)
    println()
    println("This is the ordered menu below")
    test_menu?.showMenuDetail()
}