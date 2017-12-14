package Product

import Common.*

interface Product {
    val product_id : String
    val product_name: String

}

class Beverage(override val product_name: String): Product {
    override val product_id: String = BeverageId.valueOf(this.product_name).value
}

class Dessert(override val product_name: String): Product {
    override val product_id: String = DessertId.valueOf(this.product_name).value
}




