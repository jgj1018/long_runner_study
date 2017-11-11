package bridgePattern.implLevel

import bridgePattern.APIlevel.DrawAPI
import bridgePattern.APIlevel.Shape

class Circle(val x:Int, val y:Int, val radius:Int, drawAPI: DrawAPI):Shape(drawAPI = drawAPI) {
    override fun draw() {
        drawAPI.drawCircle(radius,x,y)
    }
}