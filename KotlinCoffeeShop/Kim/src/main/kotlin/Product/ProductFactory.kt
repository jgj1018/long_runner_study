package Product

import Shop.Order
import Common.*
import Ingredient.*

class ProductFactory(var stocks: MutableMap<String, Ingredient> ) {

    fun makeProduct(order: Order): Product?
    {
        var product: Product? = null

        when (order.menu_id) {
            BeverageId.Americano.value  -> product = Beverage(product_name = "Americano")
            BeverageId.Caffelatte.value -> product = Beverage(product_name = "Caffelatte")
            BeverageId.Cappuccino.value -> product = Beverage(product_name = "Cappuccino")
            BeverageId.Espresso.value   -> product = Beverage(product_name = "Espresso")
            BeverageId.OrangeJuice.value-> product = Beverage(product_name = "OrangeJuice")
            DessertId.CheeseCake.value  -> product = Dessert(product_name = "CheeseCake")
            else                        -> println("Unknown Menu")
        }

        if (product is Product) {
            order.order_status = true
        } else {
            order.order_status = false
        }
        return product
    }
}
