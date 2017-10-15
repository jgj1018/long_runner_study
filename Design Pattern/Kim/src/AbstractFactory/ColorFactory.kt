package AbstractFactory

import AbstractFactory.Color.*


class ColorFactory : AbstractFactory() {

    override fun getColor(colorType: String): Color? {

        return when (colorType.toUpperCase()) {
            "GREEN" -> Green()
            "RED"   -> Red()
            "BLUE"  -> Blue()
            else    -> null
        }
    }

    override fun getShape(shape: String): Shape? {
        return null
    }
}