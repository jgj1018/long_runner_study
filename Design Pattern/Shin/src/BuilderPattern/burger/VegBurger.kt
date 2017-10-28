package BuilderPattern.burger

/**
 * Created by Shin on 2017/10/22.
 */
class VegBurger:Burger() {
    override fun price(): Float = 25.0f
    override fun name(): String = "Veg Burger"
}