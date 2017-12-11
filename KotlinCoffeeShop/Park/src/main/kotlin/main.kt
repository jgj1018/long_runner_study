import menu.TypeOfMenu
import shop.Shop

fun main(args: Array<String>) {
    val shop = Shop()

    val coffeeNames = setOf("Espresso", "Americano", "CafeLatte", "Cappuccino")

    shop.setUpShop(coffeeNames, TypeOfMenu.Beverage)
    val foodNames = setOf("EggSandwich", "HamSandwich", "EggMuffin", "HamMuffin", "ChickenSandiwich")
    shop.setUpShop(foodNames, TypeOfMenu.Food)

    shop.makeOrderQueue()
}