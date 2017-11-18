package menu.coffee

import helpers.addIngredientHelper
import ingredient.Cinnamon
import ingredient.Ingredient

class Cappuccino(): Espresso() {
    override var ingredients: MutableList<Ingredient> = ArrayList()
    override val name: String = "Cappuccino"

    constructor(espresso: Espresso) : this() {

        addIngredient(espresso)
    }

    override fun addIngredient(coffee: Coffee) {
        addIngredientHelper(coffee, this, Cinnamon)

    }


}