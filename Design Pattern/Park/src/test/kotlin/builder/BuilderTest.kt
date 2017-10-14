package builder

import builder.concrete.MealBuilder
import org.junit.Test
import kotlin.test.assertEquals

class BuilderTest {
    @Test
    fun builderTest(){
        val mealBuilder = MealBuilder()
        val vegMeal = mealBuilder.prepareVegMeal()
        vegMeal.showItems()
        assertEquals(55.0f,vegMeal.getCost())
        val nonVegMeal = mealBuilder.prepareNonVegMeal()
        nonVegMeal.showItems()
        assertEquals(85.5f,nonVegMeal.getCost())

    }
}