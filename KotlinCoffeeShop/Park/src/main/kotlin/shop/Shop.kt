package shop

import helpers.menuAbstractFactory
import helpers.stockMaker
import ingredient.Ingredient
import menu.*
import menu.beverage.Beverage
import menu.food.Food
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Shop {
    private var menu:MutableMap<String,Menu> = HashMap()
    private var foodMenu:Map<String, Menu> = HashMap()
    private var beverageMenu:Map<String, Menu> = HashMap()
    private val orderQueue = LinkedList<Menu>();
    private val input = Scanner(System.`in`)

    var foodIngresStocks: Map<String, Ingredient> = HashMap()
    var beverageIngresStocks: Map<String, Ingredient> = HashMap()

    fun setUpShop(menuNames:Set<String>, strategy: TypeOfMenu) {
        this.setStocksAndMenu(menuNames, strategy)
    }


    private fun setStocksAndMenu(menuNames:Set<String>, strategy: TypeOfMenu){
        if(strategy == TypeOfMenu.Beverage){
            this.setStocksAndMenuForBeve(menuNames,strategy)
        }
        if(strategy == TypeOfMenu.Food){
            this.setStocksAndMenuForFood(menuNames,strategy)
        }


    }


    private fun setStocksAndMenuForFood(menuNames:Set<String>, strategy: TypeOfMenu){
        foodIngresStocks = stockMaker(strategy)
        foodMenu = menuAbstractFactory(menuNames, strategy, foodIngresStocks)
        foodMenu.forEach{
            menu.put(it.key, it.value)
        }


    }


    private fun setStocksAndMenuForBeve(menuNames:Set<String>, strategy: TypeOfMenu){
        beverageIngresStocks = stockMaker(strategy)
        beverageMenu = menuAbstractFactory(menuNames, strategy, beverageIngresStocks)
        beverageMenu.forEach{
            menu.put(it.key, it.value)
        }
    }


    fun showMenu(){
        println("order Please")
        try{
            showBeverageMenu()
            showFoodMenu()

        }catch (e: NullPointerException){

        }
    }


    fun showBeverageMenu(){
        this.beverageMenu.values.forEach{

            print("상품명:${it.name} 가격:${it.price} ")
            it.showIngredients(beverageIngresStocks)
        }
    }


    fun showFoodMenu(){
        this.foodMenu.values.forEach{

            print("상품명:${it.name} 가격:${it.price} ")
            it.showIngredients(foodIngresStocks)
        }
    }


    fun makeOrderQueue(){
        showMenu()
        val name = input.nextLine()
        val order = takeOrder(name)
        orderQueue.push(order)

        if(!isOrderFinished()){
            giveProduct()
        }else{
            input.nextLine()

            makeOrderQueue()
        }
    }


    private fun giveProduct(){
        println("here We are")
        var sum = 0
        val selledProducts:MutableList<Menu> = ArrayList()
        orderQueue.forEach{
            println("Menu: ${it.name}")
            sum+=it.price
            selledProducts.add(it)
        }
        input.nextLine()

        do{
            println("Total price: ${sum}")
            val payed = input.nextInt()
        }while (sum != payed)

        println("Thank you")
        decreaseIngredientStocks(selledProducts)

    }


    fun decreaseIngredientStocks(selledProduct:List<Menu>){
        selledProduct.forEach{
            if(it is Food){
                val ingres = it.ingredients
                ingres.forEach{
                    val ing = foodIngresStocks.get(it.name)!!
                    ing.stock--

                }
            }
            if(it is Beverage){
                val ingres = it.ingredients
                ingres.forEach{
                    val ing = beverageIngresStocks.get(it.name)!!
                    ing.stock--

                }

            }

        }
    }


    fun isOrderFinished(): Boolean {
        println("Anything else?(true/false)")

        return input.nextBoolean()
    }


    private fun takeOrder(name:String):Menu?{
        var product:Menu? = null
        try{

            product = this.menu.get(name.toUpperCase())

        }catch (e:NullPointerException){
            println("없는 상품입니다")
        }
        finally {
            return product

        }
    }



    // Test Method
    var testFlag = false
    fun makeOrderQueueForTest(): Boolean {
        showMenu()
        val name = "HamMuffin"

        val order = takeOrderTest(name)
        orderQueue.push(order)
        if(isOrderFinishedTest()){
            return giveProductForTest()
        }else{
            testFlag = true
            return makeOrderQueueForTest();
        }
    }

    private fun giveProductForTest():Boolean{
        println("here We are")
        var sum = 0;
        orderQueue.forEach{
            println("Menu: ${it.name}")
            sum+=it.price
        }
        println("Total price: ${sum}")

        return true
    }


    fun isOrderFinishedTest(): Boolean {
        println("Anything else?")
        return testFlag
    }

    fun takeOrderTest(name:String):Menu?{
        var product:Menu? = null
        try{

            product = this.menu.get(name.toUpperCase())


        }catch (e:NullPointerException){
            println("없는 상품입니다")
        }finally {
            return product
        }
    }

}