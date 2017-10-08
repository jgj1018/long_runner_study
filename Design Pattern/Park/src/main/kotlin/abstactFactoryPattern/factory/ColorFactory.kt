package abstactFactoryPattern.factory

import abstactFactoryPattern.`object`.color.Blue
import abstactFactoryPattern.`object`.color.Color
import abstactFactoryPattern.`object`.color.Green
import abstactFactoryPattern.`object`.color.Red
import abstactFactoryPattern.`object`.shape.Circle
import abstactFactoryPattern.`object`.shape.Rectangle
import abstactFactoryPattern.`object`.shape.Shape
import abstactFactoryPattern.`object`.shape.Square

class ColorFactory : AbstractFactory() {
    override fun getColor(color: String): Color? {

        return when(color.toUpperCase()){
            "RED" -> Red()

            "GREEN" -> Green()

            "BLUE" -> Blue()

            else -> null

        }
    }

    override fun getShape(shapeType: String): Shape? {

        return null
    }
}