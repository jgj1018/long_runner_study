package builder.abs

import builder.In.Packing

class Bottle: Packing {
    override fun pack(): String {
        return "Bottle"
    }
}