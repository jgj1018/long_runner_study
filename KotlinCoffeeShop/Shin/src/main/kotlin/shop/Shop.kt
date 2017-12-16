package shop

import ingredients.Ingredient
import menu.Menu
import menu.MenuCategory
import menu.MenuList
import menu.Recipe
import shop.staff.Barista
import shop.staff.CounterStaff
import shop.Stock

/**
 * CounterStaff와 Barista가 있을거임
 */
class Shop {
    val pos = POS()
    val counterStaff = CounterStaff(this, pos)
    val barista = Barista()
    val storage = Storage()
    val menuList = MenuList()

    init {
        val coffeeIngredientOne = Ingredient("CoffeeIngredientOne", 1.00)
        val coffeeIngredientTwo = Ingredient("CoffeeIngredientTwo", 2.00)

        storage.addNewStock(Stock(coffeeIngredientOne, 2))
        storage.addNewStock(Stock(coffeeIngredientTwo, 2))

        val espresso = Menu("Espresso", MenuCategory.Coffee)
        val recipeOfEspresso = Recipe()
        recipeOfEspresso.addIngredient(coffeeIngredientOne, 1)
        recipeOfEspresso.addIngredient(coffeeIngredientTwo, 1)

        espresso.setRecipe(recipeOfEspresso)

        menuList.addMenu(espresso)
    }
}

class POS(private var money: Double = 100.0) {

    fun calculatePrice(menu: Menu):Double {
        return menu.getPrice()
    }

    fun depositMoney(money: Double) {
        this.money += money
    }

    fun getSales():Double = money
}