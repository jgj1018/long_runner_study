package bridgePattern.implLevel

import bridgePattern.APIlevel.DrawAPI

class RedCircle:DrawAPI {
    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("Draw Circle[ color: red, radius $radius, x: $x, $y]")
    }
}