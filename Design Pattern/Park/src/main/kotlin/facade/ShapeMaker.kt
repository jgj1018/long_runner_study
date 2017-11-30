package facade

class ShapeMaker {
    private val circle:Shape
    private val rectangle:Shape
    private val square:Shape

    init {
        circle = Circle()
        rectangle = Rectangle()
        square = Square()
    }

    fun drawCircle(){
        circle.draw()
    }

    fun drawRectangle(){
        rectangle.draw()
    }

    fun drawSquare(){
        square.draw()
    }
}