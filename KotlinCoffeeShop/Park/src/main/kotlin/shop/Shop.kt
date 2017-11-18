package shop

import menu.coffee.*

class Shop {
     val menu:MutableMap<String,Coffee> = HashMap()
    init {
        setMenu()
    }

    private fun setMenu(){
        val espresso = Espresso()
        val americano = Americano(espresso)
        val cafelatte = CafeLatte(americano)
        val cappucinno = Cappuccino(cafelatte)
        this.menu.put(espresso.name.toUpperCase(),espresso)
        this.menu.put(americano.name.toUpperCase(),americano)
        this.menu.put(cafelatte.name.toUpperCase(),cafelatte)
        this.menu.put(cappucinno.name.toUpperCase(),cappucinno)

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
    
    fun takeOrder(name:String, money:Int):Coffee?{
       var product:Coffee? = null
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