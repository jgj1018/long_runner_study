package DecoratorPattern

interface Shape {
    fun draw()
}

class Rectangle:Shape {
    override fun draw() {
        println("Shape: Rectangle")
    }
}

class Circle:Shape {
    override fun draw() {
        println("Shape: Circle")
    }
}

abstract class ShapeDecorator(protected val decoratedShape: Shape): Shape {
    override fun draw() {
        decoratedShape.draw()
    }
}

class RedShapeDecorator(decoratedShape: Shape):ShapeDecorator(decoratedShape) {
    override fun draw() {
        decoratedShape.draw()
        setRedBorder(decoratedShape)
    }

    private fun setRedBorder(decoratedShape: Shape) {
        println("Border Color: Red")
    }
}