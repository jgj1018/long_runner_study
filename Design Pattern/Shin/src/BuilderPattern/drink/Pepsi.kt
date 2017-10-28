package BuilderPattern.drink

/**
 * Created by Shin on 2017/10/22.
 */
class Pepsi:ColdDrink() {
    override fun price(): Float = 35.0f
    override fun name(): String = "Pepsi"
}