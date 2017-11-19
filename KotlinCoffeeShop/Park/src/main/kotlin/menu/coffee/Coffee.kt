package menu.coffee

import ingredient.Ingredient
import menu.beverage.Beverage

abstract class Coffee:Beverage {

    protected abstract fun addIngredient(coffee: Coffee, neededIngredients:MutableList<Ingredient>)

    override fun showIngredients(){
        print("재료 명 : ")
        this.ingredients.forEach {
            if(ingredients.indexOf(it) == ingredients.size -1){
                println("${it.name} ")

            }else{
                print("${it.name}, ")
            }
        }
    }
}