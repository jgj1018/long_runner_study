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
    lateinit var espresso:Espresso
    lateinit var americano:Espresso
    lateinit var cafeLatte:Espresso
    lateinit var cappuccino:Espresso
    lateinit var shop:Shop
    @Before
    fun prePareCoffee(){
        espresso = Espresso()
        americano = Americano(espresso)
        cafeLatte = CafeLatte(americano)
        cappuccino = Cappuccino(cafeLatte)
        shop = Shop()
    }

    @Test
    fun testNumberOfEspressoIngredients(){
        assertEquals(2, americano.ingredients.size)
        assertEquals(3, cafeLatte.ingredients.size)
        assertEquals(4, cappuccino.ingredients.size)


    }

    @Test
    fun testPriceOfCoffee(){
        assertEquals(americano.price , ((CoffeeBean.price + Water.price) * 1.5).toInt())
        assertEquals(cafeLatte.price , ((CoffeeBean.price + Water.price + Milk.price) * 1.5).toInt())
        assertEquals(cappuccino.price , ((CoffeeBean.price + Water.price + Milk.price + Cinnamon.price) * 1.5).toInt())

    }

    @Test
    fun testNameOfCoffee(){
        assertEquals("Espresso", espresso.name)
        assertEquals("Americano", americano.name)
        assertEquals("CafeLatte", cafeLatte.name)
        assertEquals("Cappuccino", cappuccino.name)
    }

    @Test
    fun testNumberOfMenu(){

        assertEquals(4,shop.menu.size)
    }

    @Test
    fun testOrder(){
        assertEquals(americano.name,shop.takeOrder("Americano", 165)!!.name)
    }

    @Test(expected = NullPointerException::class)
    fun testNullProduct(){
        assertEquals(americano.name,shop.takeOrder("mocha", 165)!!.name)
    }

}