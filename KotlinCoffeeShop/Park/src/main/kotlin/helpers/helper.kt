package helpers

import ingredient.Ingredient
import menu.coffee.Coffee

fun addIngredientHelper(base:Coffee, product:Coffee, additive:Ingredient){
    base.ingredients.forEach{
        product.ingredients.add(it)
    }
    product.ingredients.add(additive)

}