package BuilderPattern

/**
 * Created by Shin on 2017/10/22.
 */
fun main(args: Array<String>) {
    val mealBuilder = MealBuilder()

    val vegMeal = mealBuilder.prepareVegMeal()
    vegMeal.showItems()
    println(vegMeal.getCost())

    val nonVegMeal = mealBuilder.prepareNonVegMeal()
    nonVegMeal.showItems()
    println(nonVegMeal.getCost())

}