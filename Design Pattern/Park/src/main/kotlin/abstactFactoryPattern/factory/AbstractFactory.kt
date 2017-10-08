package abstactFactoryPattern.factory

import abstactFactoryPattern.`object`.color.Color
import abstactFactoryPattern.`object`.shape.Shape

abstract class AbstractFactory {

    abstract fun getColor(color: String): Color?

    abstract fun getShape(shape: String): Shape?
}