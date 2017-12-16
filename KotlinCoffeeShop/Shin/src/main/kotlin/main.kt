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

    OrderManager.updateListener(barista)
    counterStaff.sayWelcome()
    counterStaff.sayMenu()
    if (counterStaff.getOrder(StandardOrder(menuList.getMenu("Espresso")!!))) {
        counterStaff.inputOrder()
    }

    counterStaff.getOrder(StandardOrder(Menu("Cake", MenuCategory.Food)))
    counterStaff.inputOrder()

    if (counterStaff.getOrder(StandardOrder(Menu("CafeLatte", MenuCategory.Coffee)))) {
        counterStaff.inputOrder()
    }

}