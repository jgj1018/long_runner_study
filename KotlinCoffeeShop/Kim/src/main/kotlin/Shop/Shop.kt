package Shop

import Menu.*

class Shop(val shop_id: String) {

    var menu_list: Map<String, Menu> = fetchMenuList(shop_id)
    var order_list: MutableList<Order> = mutableListOf<Order>()
    var menu_factory: MenuFactory = MenuFactory()

    /**
     * fetch menu data from database based on shop_id
     * @return the fetched menu data
     */
    fun fetchMenuList(shop_id: String): MutableMap<String, Menu>
    {
        //not implemented yet, below is temporary logic
        var temp_menu_list = mutableMapOf<String, Menu>()

        temp_menu_list.put(BeverageId.Americano.value, Beverage(menu_name = "Americano", menu_price = 250))
        temp_menu_list.put(BeverageId.Caffelatte.value, Beverage(menu_name = "Caffelatte", menu_price = 300))
        temp_menu_list.put(BeverageId.Cappuccino.value, Beverage(menu_name = "Cappuccino", menu_price = 300))
        temp_menu_list.put(BeverageId.Espresso.value, Beverage(menu_name = "Espresso", menu_price = 200))
        temp_menu_list.put(BeverageId.OrangeJuice.value, Beverage(menu_name = "OrangeJuice", menu_price = 400))
        temp_menu_list.put(DessertId.CheeseCake.value, Dessert(menu_name = "CheeseCake", menu_price = 500))

        return temp_menu_list
    }

    /**
     * show menu data to customer on the console
     * @return void
     */
    fun showMenuList()
    {
        try {
            if (menu_list.isNotEmpty()) {
                println("========Menu list========")
                menu_list.forEach {
                    it.value.showMenuDetail()
                }
                println("=========================")
            } else {
                throw NullPointerException("Menu list is empty")
            }
        } catch (e: NullPointerException) {
            println(e.message)
        }
    }

    /**
     * take order from a customer, this method run when there is any order from the console by a customer
     * @return menu instance
     */
    fun takeOrder(vararg orders: Order): Menu?
    {
        try {
            orders.forEach {
                if (isValidOrder(it)) {
                    this.menu_factory.makeProduct(it) ?: throw NullPointerException("Making beverage failed")
                }
            }

        } catch (e: Exception) {
            println(e.message)
        }
        return null
    }

    /**
     * check if the order is valid or not.
     * (1) check if the menu exists.
     * (2) check if the price is right.
     * (3) check if the staff is ready.
     * (4) check if the beverage is made with no problem.
     *
     * @return the boolean result of validation
     */
    private fun isValidOrder(order: Order): Boolean
    {
        var valid = true

        if (this.menu_list.get(order.menu_id) === null) {
            valid = false
            throw NullPointerException("Menu doesn't exist")
        }
        if (order.payment < this.menu_list.get(order.menu_id)!!.menu_price) {
            valid = false
            throw Exception("The amount paid is wrong")
        }
        return valid
    }
}




