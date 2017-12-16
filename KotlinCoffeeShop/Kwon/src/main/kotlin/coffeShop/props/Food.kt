package coffeShop.props

public class Food(override var price: Int,
                  override var discription: String,
                  override var type: String,
                  override var ingredient: String,
                  override var name: String) : Menu() {}
