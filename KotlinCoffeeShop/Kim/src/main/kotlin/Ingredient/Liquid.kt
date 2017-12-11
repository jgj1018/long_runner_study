package Ingredient

interface Liquid {
    val ingredient_id: String
    val ingredient_name: String
    var stock: Int
}

class Water: Liquid {
    override val ingredient_id: String = "i002"
    override val ingredient_name: String = "Water"
    override var stock: Int = 0
}