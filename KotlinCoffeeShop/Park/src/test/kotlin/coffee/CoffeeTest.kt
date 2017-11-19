package coffee

import ingredient.Cinnamon
import ingredient.CoffeeBean
import ingredient.Milk
import ingredient.Water
import menu.coffee.*
import org.junit.Before
import org.junit.Test
import shop.Shop
import kotlin.test.assertEquals

class CoffeeTest{
    lateinit var shop:Shop
    @Before
    fun prePareCoffee(){
        shop = Shop()
        val coffeeNames = setOf("Espresso", "Americano", "CafeLatte", "Cappuccino")
        shop.setMenu(coffeeNames)
    }

    @Test
    fun testNumberOfEspressoIngredients(){
        assertEquals(2, shop.takeOrder("Americano", 165)!!.ingredients.size)
        assertEquals(3, shop.takeOrder("CafeLatte", ((CoffeeBean.price + Water.price + Milk.price) *1.5).toInt())!!.ingredients.size)
        assertEquals(4, shop.takeOrder("Cappuccino", ((CoffeeBean.price + Water.price + Milk.price + Cinnamon.price) *1.5).toInt())!!.ingredients.size)

    }

    @Test
    fun testPriceOfCoffee(){
        assertEquals(165, shop.takeOrder("Americano", 165)!!.price)
        assertEquals( ((CoffeeBean.price + Water.price + Milk.price) *1.5).toInt(), shop.takeOrder("CafeLatte", ((CoffeeBean.price + Water.price + Milk.price) *1.5).toInt())!!.price)
        assertEquals(((CoffeeBean.price + Water.price + Milk.price + Cinnamon.price) *1.5).toInt(), shop.takeOrder("Cappuccino", ((CoffeeBean.price + Water.price + Milk.price + Cinnamon.price) *1.5).toInt())!!.price)

    }

    @Test
    fun testNameOfCoffee(){
        assertEquals("Espresso", shop.takeOrder("Espresso", (CoffeeBean.price*1.5).toInt())!!.name)
        assertEquals( "Americano", shop.takeOrder("Americano", ((CoffeeBean.price + Water.price ) *1.5).toInt())!!.name)
        assertEquals("CafeLatte", shop.takeOrder("CafeLatte", ((CoffeeBean.price + Water.price + Milk.price ) *1.5).toInt())!!.name)
    }

    @Test
    fun testNumberOfMenu(){

        assertEquals(4,shop.menu.size)
    }


    @Test(expected = NullPointerException::class)
    fun testNullProduct(){
        assertEquals("Espresso",shop.takeOrder("mocha", 165)!!.name)
    }

}