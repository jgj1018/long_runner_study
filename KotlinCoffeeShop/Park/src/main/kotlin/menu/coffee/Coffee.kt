package menu.coffee

import ingredient.Ingredient

abstract class Coffee {
    abstract var ingredients: MutableList<Ingredient>
    abstract val price:Int
    abstract val name:String
    protected abstract fun addIngredient(coffee: Coffee)

    fun showIngredients(){
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