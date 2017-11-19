package menu.beverage

import ingredient.Ingredient

interface Beverage {
     var ingredients: MutableList<Ingredient>
     val price:Int
     val name:String

    fun showIngredients()
}