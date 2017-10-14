package builder.concrete

import builder.abs.ColdDrink

class Coke:ColdDrink() {
    override fun name(): String {
        return "Coke"
    }

    override fun price(): Float {
        return 30.0f
    }
}