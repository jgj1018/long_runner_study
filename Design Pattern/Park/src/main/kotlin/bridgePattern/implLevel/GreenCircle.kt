package bridgePattern.implLevel

import bridgePattern.APIlevel.DrawAPI

class GreenCircle:DrawAPI {
    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("Draw Circle[ color: green, radius $radius, x: $x, $y]")
    }
}