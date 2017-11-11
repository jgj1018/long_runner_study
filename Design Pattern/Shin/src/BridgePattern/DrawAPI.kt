package BridgePattern

interface DrawAPI {
    fun drawCircle(radius:Int, x:Int, y:Int)
}

class RedCircle:DrawAPI {
    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("Drawing Circle[ color: red, radius: $radius, x: $x, y: $y]")
    }
}

class GreenCircle:DrawAPI {
    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("Drawing Circle[ color: green, radius: $radius, x: $x, y: $y]")
    }
}