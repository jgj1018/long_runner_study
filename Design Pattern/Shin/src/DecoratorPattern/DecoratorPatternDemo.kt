package DecoratorPattern

fun main(args: Array<String>) {
    val circle = Circle()
    val redCircle = RedShapeDecorator(Circle())
    val redRectanble = RedShapeDecorator(Circle())

    println("Circle with normal border")
    circle.draw()

    println("Circle of red border")
    redCircle.draw()

    println("Rectangle of red border")
    redRectanble.draw()
}