package decorator.concreteLevel

import decorator.apiLevel.Shape
import decorator.apiLevel.ShapeDecorator

class RedShapeDecorator(decoratedShape:Shape):ShapeDecorator(decoratedShape = decoratedShape) {
    override fun draw() {
        decoratedShape.draw()
        setRedBorder(decoratedShape)
    }

    private fun setRedBorder(decoratedShape: Shape){
        println("Border Color: Red")
    }
}