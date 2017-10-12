package abstractfactorypattern

import abstractfactorypattern.factory.AbstractFactory

public class AbstractFactoryPatternDemo{

}

fun main(args: Array<String>) {
    val shapeFactory : AbstractFactory? = FactoryProducer.getFactory("SHAPE")

    val shape1 = shapeFactory!!.getShape("CIRCLE")
        shape1!!.draw()
    val shape2 = shapeFactory!!.getShape("RECTANGLE")
        shape2!!.draw()
    val shape3 = shapeFactory!!.getShape("SQUARE")
        shape3!!.draw()

    val colorFactory : AbstractFactory? = FactoryProducer.getFactory("COLOR")

    val color1 = colorFactory!!.getColor("RED")
        color1!!.fill()
    val color2 = colorFactory!!.getColor("GREEN")
        color2!!.fill()
    val color3 = colorFactory!!.getColor("BLUE")
        color3!!.fill()

}
