package decorator.apiLevel

abstract class ShapeDecorator(protected val decoratedShape: Shape) :Shape {

    override fun draw() {
        decoratedShape.draw()
    }
}