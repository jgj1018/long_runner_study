package Shop

import Menu.*

class Shop(val shop_id: String) {

    var menu_list: Map<String, Menu> = fetchMenuList(shop_id)
    var order_list: MutableList<Menu> = mutableListOf<Menu>() // not implemented yet regarding management of order_list
    var coffee_machine: BeverageFactory = BeverageFactory()

    /**
     * fetch menu data from database based on shop_id
     * @return the fetched menu data
     */
    fun fetchMenuList(shop_id: String): MutableMap<String, Menu>
    {
        //not implemented yet, below is temporary logic
        var temp_menu_list = mutableMapOf<String, Menu>()

        temp_menu_list.put(Beverage.Americano.value, NewBeverage(menu_name = "Americano", menu_price = 250))
        temp_menu_list.put(Beverage.Caffelatte.value, NewBeverage(menu_name ="Caffelatte", menu_price = 300))
        temp_menu_list.put(Beverage.Cappuccino.value, NewBeverage(menu_name ="Cappuccino", menu_price = 300))
        temp_menu_list.put(Beverage.Espresso.value, NewBeverage(menu_name ="Espresso", menu_price = 200))

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
    fun takeOrder(menu_id: String, payment: Int): Menu?
    {
        try {
            if (isValidOrder(menu_id, payment)) {
                return this.coffee_machine.makeBeverage(menu_id) ?: throw NullPointerException("Making beverage failed")
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
    private fun isValidOrder(menu_id: String, payment: Int): Boolean
    {
        var valid = true

        if (this.menu_list.get(menu_id) === null) {
            valid = false
            throw NullPointerException("Menu doesn't exist")
        }
        if (payment < this.menu_list.get(menu_id)!!.menu_price) {
            valid = false
            throw Exception("The amount paid is wrong")
        }
        return valid
    }
}




