import shop.Shop

fun main(args: Array<String>) {
    val shop = Shop()
    val coffeeNames = setOf("Espresso", "Americano", "CafeLatte", "Cappuccino")
    shop.setMenu(coffeeNames)
    shop.showMenu();
    println("Order Americano, hand over 165 dollor")
    val coffee = shop.takeOrder("Americano", 165);

    print("HERE WE Are")
    println(coffee!!.name)

}