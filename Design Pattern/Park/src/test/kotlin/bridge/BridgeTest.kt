package bridge

import bridgePattern.implLevel.Circle
import bridgePattern.implLevel.GreenCircle
import bridgePattern.implLevel.RedCircle
import org.junit.Test

class BridgeTest {
    @Test
    fun bridgeTest(){
        val redCircle = Circle(100,100,10,RedCircle())
        val greenCircle = Circle(100,100,10,GreenCircle())

        redCircle.draw()
        greenCircle.draw()
    }
}