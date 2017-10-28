package BuilderPattern

import BuilderPattern.packings.Packing

/**
 * Created by Shin on 2017/10/22.
 */
interface Item {
    fun name():String
    fun packing():Packing
    fun price():Float
}