package abstractfactorypattern.factory

import abstractfactorypattern.`interface`.Color
import abstractfactorypattern.`interface`.Shape
import abstractfactorypattern.color.Blue
import abstractfactorypattern.color.Green
import abstractfactorypattern.color.Red

public class ColorFactory () : AbstractFactory() {

    override fun getShape(shape: String?): Shape? = null
    override fun getColor(color: String?): Color? {
        return when(color) {
            "RED" -> Red()
            "BLUE" -> Blue()
            "GREEN" -> Green()
            else -> null
        }
    }
}
