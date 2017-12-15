package Shop

import Menu.*
import Common.*
import Product.*
import Ingredient.*

class Shop(val shop_id: String) {

    var menu_list: Map<String, Menu> = fetchMenuList(shop_id)
    var order_list: MutableList<Order> = mutableListOf<Order>()
    var stock_list: MutableMap<String, Ingredient> = fetchStockStatus(shop_id)
    var menu_factory: ProductFactory = ProductFactory(stock_list)

    /**
     * fetch menu data from database based on shop_id
     * @return the fetched menu data
     */
    fun fetchMenuList(shop_id: String): MutableMap<String, Menu>
    {
        //not implemented yet, below is temporary logic
        var temp_menu_list = mutableMapOf<String, Menu>()

        temp_menu_list.put(BeverageId.Americano.value, BeverageMenu(menu_name = "Americano", menu_price = 250,
                menu_recipe = arrayOf(IngredientId.Water.value, IngredientId.Coffeebean.value)))
        //temp_menu_list.put(BeverageId.Caffelatte.value, BeverageMenu(menu_name = "Caffelatte", menu_price = 300))
        //temp_menu_list.put(BeverageId.Cappuccino.value, BeverageMenu(menu_name = "Cappuccino", menu_price = 300))
        //temp_menu_list.put(BeverageId.Espresso.value, BeverageMenu(menu_name = "Espresso", menu_price = 200))
        //temp_menu_list.put(BeverageId.OrangeJuice.value, BeverageMenu(menu_name = "OrangeJuice", menu_price = 400))
        temp_menu_list.put(DessertId.CheeseCake.value, DessertMenu(menu_name = "CheeseCake", menu_price = 500,
                menu_recipe = arrayOf(IngredientId.Water.value, IngredientId.Bread.value, IngredientId.Cheese.value)))

        return temp_menu_list
    }

    /**
     * fetch stock status from database based on shop_id
     */
    fun fetchStockStatus(shop_id: String): MutableMap<String, Ingredient>
    {
        var temp_stock_list = mutableMapOf<String, Ingredient>()

        temp_stock_list.put(IngredientId.Water.value, Water())
        temp_stock_list.put(IngredientId.Bread.value, Bread())
        temp_stock_list.put(IngredientId.Cheese.value, Cheese())
        temp_stock_list.put(IngredientId.Coffeebean.value, Coffeebean())

        return temp_stock_list
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
    fun takeOrder(vararg orders: Order): Product?
    {
        try {
            orders.forEach {
                if (isValidOrder(it)) {
                    this.menu_factory.makeProduct(it) ?: throw NullPointerException("Making beverage failed")
                    this.order_list.add(it)
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
     * (4) check if the status of stock is fine.
     *
     * @return the boolean result of validation
     */
    private fun isValidOrder(order: Order): Boolean
    {
        var valid = true
        var selected_menu = this.menu_list.get(order.menu_id)

        if (selected_menu === null) {
            valid = false
            throw Exception("Menu doesn't exist")
        }
        if (order.payment < selected_menu.menu_price) {
            valid = false
            throw Exception("The amount paid is wrong")
        }
        if (!isStockReady(selected_menu)) {
            valid = false
            throw Exception("The stock is empty")
        }
        return valid
    }

    private fun isStockReady(selected_menu: Menu): Boolean
    {
        var stock_status = true
        selected_menu.menu_recipe.forEach {
            if (stock_list.get(it)!!.stock === 0) {
                stock_status = false
            }
        }
        return stock_status
    }
}




