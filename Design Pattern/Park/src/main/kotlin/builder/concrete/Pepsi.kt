package builder.concrete

import builder.abs.ColdDrink

class Pepsi:ColdDrink() {
    override fun name(): String {
        return "Pepsi"
    }

    override fun price(): Float {
        return 35.0f
    }
}