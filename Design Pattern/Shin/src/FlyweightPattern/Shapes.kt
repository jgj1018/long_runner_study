package FlyweightPattern

interface Shape {
    fun draw()
}

class Circle(var color:String):Shape {
    var x:Int = 0
    var y:Int = 0
    var radius:Int = 0

    override fun draw() {
        println("Circle::Draw() [Color: $color, x: $x, y: $y, radius: $radius")
    }
}

