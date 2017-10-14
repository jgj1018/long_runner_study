package builder.concrete

import builder.abs.Burger

class ChickenBurger:Burger() {
    override fun name(): String {
        return "Chicken Burger"
    }

    override fun price(): Float {
        return 50.5f
    }
}