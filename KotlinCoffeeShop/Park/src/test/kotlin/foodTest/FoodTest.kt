package foodTest

import ingredient.Ingredient
import menu.Menu
import menu.TypeOfMenu
import menu.food.Food
import org.junit.Before
import org.junit.Test
import shop.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FoodTest {
    lateinit var shop:Shop
    @Before
    fun prePareCoffee(){
        shop = Shop()
        val foodNames = setOf("EggSandwich", "HamSandwich", "EggMuffin", "HamMuffin", "ChickenSandiwich")
        shop.setUpShop(foodNames, TypeOfMenu.Food)
    }

    @Test
    fun testNumberOfEspressoIngredients(){
        assertEquals(3, shop.takeOrderTest("HamMuffin")!!.ingredients.size)
        assertEquals( 4, shop.takeOrderTest("EggSandwich")!!.ingredients.size)

    }

    @Test
    fun testPriceOfCoffee(){
        assertEquals(135, shop.takeOrderTest("HamMuffin")!!.price)
        assertEquals( 68, shop.takeOrderTest("EggSandwich")!!.price)

    }



    @Test
    fun testNameOfFood(){
        assertEquals("HamMuffin", shop.takeOrderTest("HamMuffin")!!.name)
        assertEquals( "EggSandwich", shop.takeOrderTest("EggSandwich")!!.name)
    }

    @Test
    fun testDecrese(){
        val bun = Ingredient(20,"Bun",10)
        val ham = Ingredient(25,"Ham",10)
        val cheese = Ingredient(30,"Cheese",10)
        val ingres:MutableList<Ingredient> = listOf(bun, ham, cheese).toMutableList()
        val t =Food("HamMuffin",ingres )
        val menu:List<Menu> = listOf(t)
        shop.decreaseIngredientStocks(menu)
        val result =  shop.foodIngresStocks.get("Bun")
        assertEquals(9, result!!.stock)
        println("====================")
        shop.showMenu()
    }


    @Test(expected = NullPointerException::class)
    fun testNullProduct(){
        assertEquals("Espresso",shop.takeOrderTest("mocha")!!.name)
    }
    @Test
    fun testSingleQueue(){
        assertTrue(shop.makeOrderQueueForTest())
    }


    @Test
    fun testMultipleQueue(){
        assertTrue(shop.makeOrderQueueForTest())
    }

}