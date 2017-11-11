package BridgePattern

abstract class Shape(protected var drawAPI:DrawAPI) {
    abstract fun draw()
}

class Circle(private var x:Int, private var y:Int, private var radius:Int, drawAPI: DrawAPI):Shape(drawAPI) {
    override fun draw() {
        drawAPI.drawCircle(radius, x, y)
    }
}