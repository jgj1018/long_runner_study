package menu.coffee

import ingredient.CoffeeBean
import ingredient.Ingredient

open class Espresso:Coffee {
    override var ingredients: MutableList<Ingredient>
    override val name: String = "Espresso"
    override val price: Int
        get() = ((ingredients.sumBy { it.price }) * 1.5).toInt()
    private val coffeeBase:String = "Espresso"

    constructor() {
        ingredients = ArrayList()
        addIngredient(this)
    }

     override fun addIngredient(coffee: Coffee) {
        this.ingredients.add(CoffeeBean)
    }
}