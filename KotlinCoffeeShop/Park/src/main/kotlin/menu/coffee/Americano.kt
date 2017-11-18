package menu.coffee
import helpers.addIngredientHelper
import ingredient.Ingredient
import ingredient.Water

class Americano():Espresso() {
    override var ingredients: MutableList<Ingredient> = ArrayList()
    override val name: String = "Americano"

    constructor(espresso: Espresso) : this() {

        addIngredient(espresso)
    }

    override fun addIngredient(coffee: Coffee) {
        addIngredientHelper(coffee,this,Water)
    }
}