package Ingredient

interface Solid {
    val ingredient_id: String
    val ingredient_name: String
    var stock: Int
}

class CoffeeBean: Solid {
    override val ingredient_id: String = "i001"
    override val ingredient_name: String = "Coffee bean"
    override var stock: Int = 10
}

