package BuilderPattern.drink

/**
 * Created by Shin on 2017/10/22.
 */
class Coke:ColdDrink() {
    override fun price(): Float = 30.0f
    override fun name(): String = "Coke"
}