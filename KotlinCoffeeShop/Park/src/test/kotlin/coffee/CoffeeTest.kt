package coffee

import menu.TypeOfMenu
import org.junit.Before
import org.junit.Test
import shop.*
import kotlin.test.assertEquals

class CoffeeTest{
    lateinit var shop:Shop
    @Before
    fun prePareCoffee(){
        shop = Shop()
        val coffeeNames = setOf("Espresso", "Americano", "CafeLatte", "Cappuccino")
        shop.setUpShop(coffeeNames, TypeOfMenu.Beverage)

    }

    @Test
    fun testNumberOfEspressoIngredients(){
        assertEquals(2, shop.takeOrderTest("Americano")!!.ingredients.size)
        assertEquals(3, shop.takeOrderTest("CafeLatte")!!.ingredients.size)
        assertEquals(4, shop.takeOrderTest("Cappuccino")!!.ingredients.size)

    }

    @Test
    fun testPriceOfCoffee(){
        assertEquals(66, shop.takeOrderTest("Americano")!!.price)
        assertEquals( 85, shop.takeOrderTest("CafeLatte")!!.price)
        assertEquals(91, shop.takeOrderTest("Cappuccino")!!.price)

    }

    @Test
    fun testNameOfCoffee(){
        assertEquals("Espresso", shop.takeOrderTest("Espresso")!!.name)
        assertEquals( "Americano", shop.takeOrderTest("Americano")!!.name)
        assertEquals("CafeLatte", shop.takeOrderTest("CafeLatte")!!.name)
    }








    @Test(expected = NullPointerException::class)
    fun testNullProduct(){
        assertEquals("Espresso",shop.takeOrderTest("mocha")!!.name)
    }



}