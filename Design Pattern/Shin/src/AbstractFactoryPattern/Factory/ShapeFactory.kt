package AbstractFactoryPattern.Factory

import AbstractFactoryPattern.ColorCategory
import AbstractFactoryPattern.Colors.Color
import AbstractFactoryPattern.ShapeCategory
import AbstractFactoryPattern.Shapes.Circle
import AbstractFactoryPattern.Shapes.Rectangle
import AbstractFactoryPattern.Shapes.Shape
import AbstractFactoryPattern.Shapes.Square

/**
 * Created by Shin on 2017/10/04.
 */
class ShapeFactory:AbstractFactory() {
    override fun getShape(shape: ShapeCategory):Shape? {
        when (shape) {
            ShapeCategory.Circle -> return Circle()
            ShapeCategory.Rectangle -> return Rectangle()
            ShapeCategory.Square -> return Square()
            else -> return null
        }
    }

    override fun getColor(color: ColorCategory): Color? {
        return null
    }
}