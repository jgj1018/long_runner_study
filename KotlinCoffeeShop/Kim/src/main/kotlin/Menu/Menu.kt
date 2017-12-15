package Menu

import Common.*
import Ingredient.*

interface Menu {
    val menu_id: String
    val menu_name: String
    val menu_price: Int
    val menu_recipe: Array<String>

    fun showMenuDetail()
}

class BeverageMenu(override val menu_name: String, override val menu_price: Int, override val menu_recipe: Array<String>) : Menu {
    override val menu_id: String = BeverageId.valueOf(this.menu_name).value

    override fun showMenuDetail() {
        println("Name: ${this.menu_name} Price: ${this.menu_price}")
    }
}

class DessertMenu(override val menu_name: String, override val menu_price: Int, override val menu_recipe: Array<String>) : Menu {
    override val menu_id: String = DessertId.valueOf(this.menu_name).value

    override fun showMenuDetail() {
        println("Name: ${this.menu_name} Price: ${this.menu_price}")
    }
}