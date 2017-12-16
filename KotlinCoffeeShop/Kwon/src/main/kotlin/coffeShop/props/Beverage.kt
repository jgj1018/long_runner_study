package coffeShop.props

public data class Beverage(override var price: Int,
                           override var discription: String,
                           override var type: String,
                           override var ingredient: String,
                           override var name: String) : Menu() {}
