package Menu


/**
 * This factory makes instance of Beverage by using Beverage Enum and NewBeverage Class.
 * The makeBeverage is only method this class has.
 */
class BeverageFactory {

    fun makeBeverage(menu_id: String): Menu?
    {
        var beverage: Menu? = null

        when (menu_id) {
            Beverage.Americano.value  -> beverage = NewBeverage(menu_name = "Americano", menu_price = 250)
            Beverage.Caffelatte.value -> beverage = NewBeverage(menu_name ="Caffelatte", menu_price = 300)
            Beverage.Cappuccino.value -> beverage = NewBeverage(menu_name ="Cappuccino", menu_price = 300)
            Beverage.Espresso.value   -> beverage = NewBeverage(menu_name ="Espresso", menu_price = 200)
            else                      -> println("Unknown Menu")
        }
        return beverage
    }
}

/**
 * Beverage Enum has two purposes
 * (1) to manage to map between menu_name and menu_id
 * (2) to make code easy to read.
 */
enum class Beverage (val value: String) {
    Americano("m001"),
    Caffelatte("m002"),
    Espresso("m003"),
    Cappuccino("m004"),
    Unknown("m999")
}


/**
 * This class is an instance of Beverage. the properties is based on the scheme of the Beverage table in the database.
 */
class NewBeverage (override val menu_name: String, override val menu_price: Int): Menu {

    override val menu_id: String = Beverage.valueOf(this.menu_name).value
    override val recipe: Array<String> = arrayOf("A", "B", "C") // not implemented yet regarding recipe

    override fun showMenuDetail() {
        println("Name: ${this.menu_name} Price: ${this.menu_price}")
    }

    override fun showRecipeDetail() {
        this.recipe.forEach { println(it) } // not implemented yet regarding recipe
    }
}