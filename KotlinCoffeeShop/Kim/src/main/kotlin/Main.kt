import Shop.*
import Common.*

fun main(args: Array<String>) {

    val test_shop: Shop = Shop(shop_id = "s001")
    test_shop.fetchMenuList(test_shop.shop_id)
    test_shop.showMenuList()
    println("Customer: One Americano please")
    test_shop.takeOrder(Order(1, DessertId.CheeseCake.value, 500),
                        Order(2, BeverageId.OrangeJuice.value, 400))
    println()
    println("order list is below")
    println(test_shop.order_list)
}