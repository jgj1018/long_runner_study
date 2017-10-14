package builder.abs

import builder.In.Item
import builder.In.Packing

abstract class Burger: Item {
    override fun packing(): Packing {
        return Wrapper()
    }

}