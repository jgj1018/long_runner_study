package AbstractFactoryPattern.Factory

import AbstractFactoryPattern.ColorCategory
import AbstractFactoryPattern.Colors.Color
import AbstractFactoryPattern.ShapeCategory
import AbstractFactoryPattern.Shapes.Shape

/**
 * Created by Shin on 2017/10/04.
 */
abstract class AbstractFactory {
    abstract fun getColor(color: ColorCategory):Color?
    abstract fun getShape(shape: ShapeCategory):Shape?
}