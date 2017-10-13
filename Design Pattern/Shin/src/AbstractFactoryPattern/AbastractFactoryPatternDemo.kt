package AbstractFactoryPattern

import AbstractFactoryPattern.Colors.Color
import AbstractFactoryPattern.Factory.AbstractFactory
import AbstractFactoryPattern.Factory.ColorFactory
import AbstractFactoryPattern.Factory.FactoryProducer
import AbstractFactoryPattern.Factory.ShapeFactory
import AbstractFactoryPattern.Shapes.Shape

/**
 * https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm
 *
 * Created by Shin on 2017/10/04.
 */
fun main(args: Array<String>) {

    val shapeFactory:AbstractFactory? = getFactory(ChoiceFactory.Shape)

    if (shapeFactory != null) {
        val shape1:Shape? = shapeFactory.getShape(ShapeCategory.Circle)
        shape1?.draw()

        val shape2:Shape? = shapeFactory.getShape(ShapeCategory.Rectangle)
        shape2?.draw()

        val shape3:Shape? = shapeFactory.getShape(ShapeCategory.Square)
        shape3?.draw()

        // shape4는 null이라 출력 안됨
        val shape4:Shape? = shapeFactory.getShape(ShapeCategory.Hexagon)
        shape4?.draw()
    }

    val colorFactory:AbstractFactory? = getFactory(ChoiceFactory.Color)

    if (colorFactory != null) {
        val color1: Color? = colorFactory.getColor(ColorCategory.Red)
        color1?.fill()

        val color2: Color? = colorFactory.getColor(ColorCategory.Green)
        color2?.fill()

        val color3: Color? = colorFactory.getColor(ColorCategory.Blue)
        color3?.fill()

        // color4는 null이라 출력 안됨
        val color4: Color? = colorFactory.getColor(ColorCategory.Black)
        color4?.fill()
    }

}

fun getFactory(choice:ChoiceFactory) : AbstractFactory? {
    when (choice) {
        ChoiceFactory.Color -> return ColorFactory()
        ChoiceFactory.Shape -> return ShapeFactory()
        else -> return null
    }
}