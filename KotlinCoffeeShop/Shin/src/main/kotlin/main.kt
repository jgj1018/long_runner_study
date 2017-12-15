import ingredients.Ingredient
import menu.Menu
import menu.MenuCategory
import menu.Recipe
import order.OrderManager
import order.StandardOrder
import shop.Shop
import shop.Stock

fun main(args: Array<String>) {
    val shop = Shop()
    val counterStaff = shop.counterStaff
    val barista = shop.barista
    val menuList = shop.menuList
    val storage = shop.storage


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

    OrderManager.updateListener(barista)
    counterStaff.sayWelcome()
    counterStaff.sayMenu()
    if (counterStaff.getOrder(StandardOrder(espresso))) {
        counterStaff.inputOrder()
    }

    //barista.makeBeverage()

    counterStaff.getOrder(StandardOrder(Menu("Cake", MenuCategory.Food)))
    counterStaff.inputOrder()

    if (counterStaff.getOrder(StandardOrder(Menu("CafeLatte", MenuCategory.Coffee)))) {
        counterStaff.inputOrder()
    }

    //barista.makeBeverage()
}