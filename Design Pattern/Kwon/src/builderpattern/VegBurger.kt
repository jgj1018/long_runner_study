package builderpattern

public class VegBurger : Burger() {
    override fun name(): String = "Veg Burger"

    override fun price(): Float = 25.0f
}