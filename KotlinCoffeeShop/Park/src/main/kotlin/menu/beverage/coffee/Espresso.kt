package menu.beverage.coffee

import ingredient.Ingredient
import menu.Menu

open class Espresso(override val name:String):Coffee() {

    override lateinit var ingredients: MutableList<Ingredient>

    override val price: Int
        get() = ((ingredients.sumBy { it.price }) * 1.5).toInt()

    constructor(name:String, neededIngredients:MutableList<Ingredient>) : this(name = name) {
        ingredients = ArrayList()
        addIngredient(this, neededIngredients)
    }

    override fun addIngredient(coffee: Menu, neededIngredients: MutableList<Ingredient>) {
         neededIngredients.forEach {
             this.ingredients.add(it)
         }
    }

}