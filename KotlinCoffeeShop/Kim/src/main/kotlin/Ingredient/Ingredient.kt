package Ingredient

interface Ingredient {
    val ingredient_id: String
    val ingredient_name: String
    var stock: Int
}

class Water: Ingredient {
    override val ingredient_id: String = "i001"
    override val ingredient_name: String = "Water"
    override var stock: Int = 10
}

class Coffeebean: Ingredient {
    override val ingredient_id: String = "i002"
    override val ingredient_name: String = "Coffee bean"
    override var stock: Int = 10
}

class Cheese: Ingredient {
    override val ingredient_id: String = "i003"
    override val ingredient_name: String = "Cheese"
    override var stock: Int = 10
}

class Bread: Ingredient {
    override val ingredient_id: String = "i004"
    override val ingredient_name: String = "Bread"
    override var stock: Int = 10
}