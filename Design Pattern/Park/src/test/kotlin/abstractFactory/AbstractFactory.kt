package abstractFactory

import abstactFactoryPattern.factory.AbstractFactory
import abstactFactoryPattern.factory.getFactory
import factoryPattern.factory.ShapeFactory
import org.junit.Before
import org.junit.Test

class AbstractFactory{

    lateinit var shapeFactory: AbstractFactory
    lateinit var colorFactory: AbstractFactory

    @Before
    fun beforeTest(){
        shapeFactory = getFactory("shape")!!

        colorFactory = getFactory("color")!!
    }

    @Test

    fun abstractFactoryTest(){

        val shape1 = shapeFactory.getShape("circle")
        shape1!!.draw()
        val shape2 = shapeFactory.getShape("rectangle")
        shape2!!.draw()

        val shape3 = shapeFactory.getShape("square")
        shape3!!.draw()

        val color1 = colorFactory.getColor("red")
        color1!!.fill()

        val color2 = colorFactory.getColor("blue")
        color2!!.fill()

        val color3 = colorFactory.getColor("green")
        color3!!.fill()

    }
}