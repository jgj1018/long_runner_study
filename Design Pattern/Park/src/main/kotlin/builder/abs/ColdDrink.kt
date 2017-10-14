package builder.abs

import builder.In.Item
import builder.In.Packing

abstract class ColdDrink: Item {
    override fun packing(): Packing {
        return Bottle()
    }
}