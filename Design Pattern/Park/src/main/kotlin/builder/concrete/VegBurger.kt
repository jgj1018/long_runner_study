package builder.concrete

import builder.abs.Burger

class VegBurger: Burger() {
    override fun name(): String {
        return "Veg Burger"
    }

    override fun price(): Float {
        return 25.0f
    }
}