package AbstractFactoryPattern.Factory

import AbstractFactoryPattern.ColorCategory
import AbstractFactoryPattern.Colors.Blue
import AbstractFactoryPattern.Colors.Color
import AbstractFactoryPattern.Colors.Green
import AbstractFactoryPattern.Colors.Red
import AbstractFactoryPattern.ShapeCategory
import AbstractFactoryPattern.Shapes.Shape

/**
 * Created by Shin on 2017/10/04.
 */
class ColorFactory:AbstractFactory() {
    override fun getColor(color: ColorCategory): Color? {
        when (color) {
            ColorCategory.Blue -> return Blue()
            ColorCategory.Green -> return Green()
            ColorCategory.Red -> return Red()
            else -> return null
        }
    }

    override fun getShape(shape: ShapeCategory): Shape? {
        return null
    }
}