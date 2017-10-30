package builderpattern

fun main(args: Array<String>) {

    var mealBuilder = MealBuilder()

    var vegMeal = mealBuilder.prepareVegMeal()
    println("VegMeal")
    vegMeal.showItems()
    println("Total Cost : ${vegMeal.getCost()}")

    var nonVegMeal = mealBuilder.prepareNonVegMeal()
    println("NonVegMeal")
    nonVegMeal.showItems()
    println("Total Cost : ${nonVegMeal.getCost()}")
}
