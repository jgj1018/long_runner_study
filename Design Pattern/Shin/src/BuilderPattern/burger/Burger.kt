package BuilderPattern.burger

import BuilderPattern.Item
import BuilderPattern.packings.Packing
import BuilderPattern.packings.Wrapper

/**
 * Created by Shin on 2017/10/22.
 */
abstract class Burger: Item{
    override fun packing(): Packing = Wrapper()

    abstract override fun price(): Float
}