package Menu

interface Menu {
    val menu_id: String
    val menu_name: String
    val menu_price: Int
    val recipe: Array<String> // not implemented yet regarding recipe

    fun showMenuDetail()
    fun showRecipeDetail()
}


class Beverage(override val menu_name: String, override val menu_price: Int): Menu {

    override val menu_id: String = BeverageId.valueOf(this.menu_name).value
    override val recipe: Array<String> = arrayOf("A", "B", "C") // not implemented yet regarding recipe

    override fun showMenuDetail() {
        println("Name: ${this.menu_name} Price: ${this.menu_price}")
    }

    override fun showRecipeDetail() {
        this.recipe.forEach { println(it) } // not implemented yet regarding recipe
    }
}

class Dessert(override val menu_name: String, override val menu_price: Int): Menu {

    override val menu_id: String = DessertId.valueOf(this.menu_name).value
    override val recipe: Array<String> = arrayOf("A", "B", "C") // not implemented yet regarding recipe

    override fun showMenuDetail() {
        println("Name: ${this.menu_name} Price: ${this.menu_price}")
    }

    override fun showRecipeDetail() {
        this.recipe.forEach { println(it) } // not implemented yet regarding recipe
    }
}

/**
 * Beverage Enum has two purposes
 * (1) to manage to map between menu_name and menu_id
 * (2) to make code easy to read.
 */
enum class BeverageId (val value: String) {
    Americano("m001"),
    Caffelatte("m002"),
    Espresso("m003"),
    Cappuccino("m004"),
    OrangeJuice("m005"),
}

enum class DessertId (val value: String) {
    CheeseCake("m101")
}


