package Menu

import Shop.Order

class MenuFactory {
    fun makeProduct(order: Order): Menu?
    {
        var product: Menu? = null

        when (order.menu_id) {
            BeverageId.Americano.value  -> product = Beverage(menu_name = "Americano", menu_price = 250)
            BeverageId.Caffelatte.value -> product = Beverage(menu_name = "Caffelatte", menu_price = 300)
            BeverageId.Cappuccino.value -> product = Beverage(menu_name = "Cappuccino", menu_price = 300)
            BeverageId.Espresso.value   -> product = Beverage(menu_name = "Espresso", menu_price = 200)
            BeverageId.OrangeJuice.value-> product = Beverage(menu_name = "OrangeJuice", menu_price = 400)
            DessertId.CheeseCake.value  -> product = Dessert(menu_name = "CheeseCake", menu_price = 500)
            else                      -> println("Unknown Menu")
        }

        if (product is Menu) {
            order.order_status = true
            product.showMenuDetail()
        } else {
            order.order_status = false
        }

        return product
    }
}
