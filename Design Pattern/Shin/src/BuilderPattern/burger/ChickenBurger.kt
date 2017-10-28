package BuilderPattern.burger

/**
 * Created by Shin on 2017/10/22.
 */
class ChickenBurger:Burger() {
    override fun price(): Float = 50.5f
    override fun name(): String = "Chiken Burger"
}