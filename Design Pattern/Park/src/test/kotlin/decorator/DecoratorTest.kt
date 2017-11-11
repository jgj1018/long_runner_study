package decorator

import decorator.concreteLevel.Circle
import decorator.concreteLevel.Rectangle
import decorator.concreteLevel.RedShapeDecorator
import org.junit.Test

class DecoratorTest {

    @Test
    fun testDecorator(){
        val circle = Circle()
        val redCircle = RedShapeDecorator(circle)
        val redRectangle = RedShapeDecorator(Rectangle())
        println("Circle with normal border")
        circle.draw()

        println("\nCircle of red border")
        redCircle.draw()
        println("\nRectangle of red border")
        redRectangle.draw()

    }
}