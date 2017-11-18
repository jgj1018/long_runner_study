package menu.coffee

import ingredient.Ingredient
import ingredient.Milk

import helpers.addIngredientHelper

class CafeLatte(): Espresso() {
    override var ingredients: MutableList<Ingredient> = ArrayList()
    override val name: String = "CafeLatte"

    constructor(espresso: Espresso) : this() {

        addIngredient(espresso)
    }

    override fun addIngredient(coffee: Coffee) {

        addIngredientHelper(coffee, this, Milk)

    }

}