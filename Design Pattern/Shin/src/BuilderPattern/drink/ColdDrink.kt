package BuilderPattern.drink

import BuilderPattern.Item
import BuilderPattern.packings.Bottle
import BuilderPattern.packings.Packing

/**
 * Created by Shin on 2017/10/22.
 */
abstract class ColdDrink:Item {
    override fun packing(): Packing = Bottle()
    abstract override fun price(): Float
}