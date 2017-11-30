package FacadePattern

fun main(args: Array<String>) {
    val shapeMaker = ShapeMaker()

    shapeMaker.drawCircle()
    shapeMaker.drawRectangle()
    shapeMaker.drawSquare()
}

class ShapeMaker(val circle:Shape = Circle(), val rectangle: Shape = Rectangle(), val square: Shape = Square()) {
    fun drawCircle() {
        circle.draw()
    }

    fun drawRectangle() {
        rectangle.draw()
    }

    fun drawSquare() {
        square.draw()
    }
}