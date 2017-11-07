package Decorator

class RedShapeDecorator(decoratedShape: Shape) : ShapeDecorator(decoratedShape) {

    override fun draw() {
        decoratedShape.draw()
        println("Border Color: Red")
    }
}