package factory

import factoryPattern.factory.ShapeFactory
import org.junit.Before
import org.junit.Test

class FactoryTest{

    lateinit var shapeFactory:ShapeFactory

    @Before
    fun beforeTest(){
        shapeFactory = ShapeFactory()
    }
    @Test
    fun testFactory(){
      val shape1 =  shapeFactory.getShape("circle")
        shape1!!.draw()

        val shape2 =  shapeFactory.getShape("rectangle")
        shape2!!.draw()

        val shape3 =  shapeFactory.getShape("square")
        shape3!!.draw()

    }
}