package shop

import helpers.beverageAbstractFactory
import menu.beverage.Beverage
import menu.coffee.*

class Shop {
     lateinit var menu:Map<String,Beverage>

    fun setMenu(menuNames:Set<String>) {
         menu = beverageAbstractFactory(menuNames)
    }

    fun showMenu(){
        showCoffeeMenu()
    }
    
    private fun showCoffeeMenu(){
        this.menu.values.forEach{
            print("상품명:${it.name} 가격:${it.price} ")
            it.showIngredients()
        }
    }
    
    fun takeOrder(name:String, money:Int):Beverage?{
       var product:Beverage? = null
        try{

            product = this.menu.get(name.toUpperCase())

            if(product!!.price == money){
                return product
            }

        }catch (e:NullPointerException){
            println("없는 상품입니다")
        }
        return null
    }
}