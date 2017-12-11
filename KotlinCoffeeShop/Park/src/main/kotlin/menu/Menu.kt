package menu

import ingredient.Ingredient

interface Menu{
    val price:Int
    val name:String
    var ingredients: MutableList<Ingredient>
    fun addIngredient(coffee: Menu, neededIngredients:MutableList<Ingredient>)
     fun showIngredients(ingresStocks: Map<String, Ingredient>){
        print("재료 명 : ")
        this.ingredients.forEach {
            val ingredient = ingresStocks.get(it.name)!!
            if(ingredients.indexOf(it) == ingredients.size -1){
                println("${ingredient.name}, (${ingredient.stock})")

            }else{
                print("${ingredient.name}, (${ingredient.stock})")
            }
        }
    }
}