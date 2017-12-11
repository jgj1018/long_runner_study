package menu.food

import ingredient.Ingredient
import menu.Menu
import menu.beverage.coffee.Coffee

class Food(override val name: String):Menu {
    override val price: Int
        get() = ((ingredients.sumBy { it.price }) * 1.8).toInt()

    override lateinit var ingredients: MutableList<Ingredient>

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

