package helpers

import ingredient.*
import menu.beverage.Beverage
import menu.coffee.Espresso

fun beverageAbstractFactory(menuNames:Set<String>):Map<String,Beverage>{
    var menus:MutableMap<String, Beverage> = HashMap()
    val mutableNames:MutableSet<String> = menuNames.toMutableSet()
    menuNames.forEach{
        espressoMaker(it, menus)
        mutableNames.remove(it)
    }
    return menus.toMap()

}


fun espressoMaker(name: String, menus: MutableMap<String, Beverage>) {
    var ingredients:MutableList<Ingredient>
    val upperName = name.toUpperCase()
    when(upperName){
        "ESPRESSO" ->{
            ingredients = arrayListOf(CoffeeBean)
        }
        "AMERICANO" ->{
            ingredients = arrayListOf(CoffeeBean, Water)
        }
        "CAFELATTE" ->{
            ingredients = arrayListOf(CoffeeBean, Water, Milk)
        }
        "CAPPUCCINO" ->{
            ingredients = arrayListOf(CoffeeBean, Water, Milk, Cinnamon)
        }
        else->{
            ingredients = ArrayList()
        }

    }
    menus.put(upperName, Espresso(name, ingredients))


}