package bridgepattern

public class Circle() : Shape() {
   var x : Int =0
   var y : Int =0
   var radius : Int =0

    constructor(x :Int, y :Int, radius :Int, drawAPI: DrawAPI) : this() {
        super.drawAPI = drawAPI
        this.x = x
        this.y = y
        this.radius = radius
    }

    override fun draw() {
        drawAPI.drawCircle(radius, x, y)
    }
}