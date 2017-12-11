package helpers

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import ingredient.*
import ingredient.beverageIngredient.*
import ingredient.foodIngredient.*
import menu.Menu
import menu.TypeOfMenu
import menu.beverage.coffee.*
import menu.food.Food
import java.io.FileReader
import java.io.File



fun menuAbstractFactory(menuNames:Set<String>, strategy:TypeOfMenu, stocks:Map<String, Ingredient>):Map<String,Menu>{

    var menus:MutableMap<String, Menu> = HashMap()
    val mutableNames:MutableSet<String> = menuNames.toMutableSet()

    menuNames.forEach{
        if(strategy == TypeOfMenu.Food){

            foodoMaker(it, menus, stocks)
        }else{

            espressoMaker(it, menus, stocks)
        }
        mutableNames.remove(it)
    }

    return menus.toMap()

}

fun stockMaker(strategy:TypeOfMenu):Map<String,Ingredient> {
    val gson = GsonBuilder().setPrettyPrinting().create()

    val type = object : TypeToken<Map<String, Ingredient>>() {}.type

    val path = File(".")
    val target= if(strategy == TypeOfMenu.Beverage) "/src/beverageStock.json" else "/src/foodStock.json"
    val stockMap: Map<String,Ingredient> = gson.fromJson(FileReader(path.absolutePath+target), type)
    return stockMap
}

fun espressoMaker(name: String, menus: MutableMap<String, Menu>, beverageStock:Map<String, Ingredient>) {

    val ingredients:MutableList<Ingredient>
    val upperName = name.toUpperCase()
    val coffeeBean = beverageStock.get(TypeOfBeverageIngredient.COFFEEBEAN.ingredientName)!!
    val water = beverageStock.get(TypeOfBeverageIngredient.WATER.ingredientName)!!
    val milk = beverageStock.get(TypeOfBeverageIngredient.MILK.ingredientName)!!
    val cinnamon = beverageStock.get(TypeOfBeverageIngredient.CINNAMON.ingredientName)!!

    when(upperName){

        "ESPRESSO" ->{
            ingredients = arrayListOf(coffeeBean)
        }

        "AMERICANO" ->{
            ingredients = arrayListOf(coffeeBean, water)
        }

        "CAFELATTE" ->{
            ingredients = arrayListOf(coffeeBean, water, milk)
        }

        "CAPPUCCINO" ->{
            ingredients = arrayListOf(coffeeBean, water, milk, cinnamon)
        }

        "NEWCOFFEE" ->{
            ingredients = arrayListOf(coffeeBean, milk, cinnamon)
        }

        else->{
            ingredients = ArrayList()
        }

    }
    menus.put(upperName, Espresso(name, ingredients))

}





fun foodoMaker(name: String, menus: MutableMap<String, Menu>, foodStock:Map<String, Ingredient>) {

    val ingredients:MutableList<Ingredient>
    val upperName = name.toUpperCase()

    val sandwichBread = foodStock.get(TypeOfFoodIngredient.SANDWICHBREAD.ingredientName)!!
    val bun = foodStock.get(TypeOfFoodIngredient.BUN.ingredientName)!!
    val chickenbreast = foodStock.get(TypeOfFoodIngredient.CHICKENBREAST.ingredientName)!!
    val egg = foodStock.get(TypeOfFoodIngredient.EGG.ingredientName)!!
    val ham = foodStock.get(TypeOfFoodIngredient.HAM.ingredientName)!!
    val lettuce = foodStock.get(TypeOfFoodIngredient.LETTUCE.ingredientName)!!
    val cheese = foodStock.get(TypeOfFoodIngredient.CHEESE.ingredientName)!!

    val tomato = foodStock.get(TypeOfFoodIngredient.TOMATO.ingredientName)!!

    when(upperName){

        "EggSandwich".toUpperCase() ->{
            ingredients = arrayListOf(sandwichBread,egg, tomato, lettuce)
        }

        "HamSandwich".toUpperCase() ->{
            ingredients = arrayListOf(sandwichBread,ham, tomato, lettuce)
        }

        "EggMuffin".toUpperCase() ->{
            ingredients = arrayListOf(bun, egg, cheese)
        }

        "HamMuffin".toUpperCase() ->{
            ingredients = arrayListOf(bun, ham, cheese)
        }

        "ChickenSandiwich".toUpperCase() ->{
            ingredients = arrayListOf(sandwichBread, chickenbreast, tomato, lettuce)
        }

        else->{
            ingredients = ArrayList()
        }

    }
    menus.put(upperName, Food(name, ingredients))

}