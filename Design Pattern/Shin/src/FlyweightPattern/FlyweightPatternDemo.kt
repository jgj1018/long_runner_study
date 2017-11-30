package FlyweightPattern

fun main(args: Array<String>) {

    for(i in 0 .. 20) {
        var circle:Circle = ShapeFactory.getCircle(getRandomColor()) as Circle
        circle.x = getRandomX()
        circle.y = getRandomY()
        circle.radius = 100
        circle.draw()
    }
}
val colors = arrayOf<String>("Red", "Green", "Blue", "White", "Black")

fun getRandomColor():String {
    return colors[(Math.random()*colors.size).toInt()]
}

fun getRandomX():Int = (Math.random() * 100).toInt()
fun getRandomY():Int = (Math.random() * 100).toInt()

object ShapeFactory {
    private val circleMap = hashMapOf<String, Shape>()

    fun getCircle(color:String):Shape {
        var circle = circleMap.get(color) as Circle?
        if (circle == null) {
            circle = Circle(color)
            circleMap.put(color, circle)
            println("Creating circle of color: $color")
        }

        return circle
    }
}