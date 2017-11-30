package flyweight

val colors = arrayOf("Red", "Green", "Blue", "White", "Black")
fun main(args: Array<String>) {
    for (i in 0..20 ){
        val circle:Circle = ShapeFactory.getCircle(getRandomColor()) as Circle
        circle.x = getRandomX()
        circle.y = getRandomY()
        circle.draw()
    }
}


fun getRandomColor():String = colors[(Math.random() * colors.size).toInt()]

fun getRandomX():Int = (Math.random() * 100).toInt()

fun getRandomY():Int = (Math.random() * 100).toInt()