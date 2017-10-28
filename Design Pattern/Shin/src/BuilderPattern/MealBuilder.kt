package BuilderPattern

import BuilderPattern.burger.ChickenBurger
import BuilderPattern.burger.VegBurger
import BuilderPattern.drink.Coke
import BuilderPattern.drink.Pepsi

/**
 * Created by Shin on 2017/10/22.
 */
class MealBuilder {
    fun prepareVegMeal():Meal {
        val meal = Meal()
        meal.addItem(VegBurger())
        meal.addItem(Coke())
        return meal
    }

    fun prepareNonVegMeal():Meal {
        val meal = Meal()
        meal.addItem(ChickenBurger())
        meal.addItem(Pepsi())
        return meal
    }
}