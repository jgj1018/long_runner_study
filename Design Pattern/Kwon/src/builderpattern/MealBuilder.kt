package builderpattern

public class MealBuilder {

    public fun prepareVegMeal() : Meal{
        var meal = Meal()
        meal.addItem(VegBurger())
        meal.addItem(Coke())

        return meal
    }

    public fun prepareNonVegMeal() : Meal {
        var meal = Meal()
        meal.addItem(ChickenBurger())
        meal.addItem(Pepsi())
        return meal
    }
}