package bridge

import bridgePattern.addtionalBridge.functional.*
import bridgePattern.addtionalBridge.implementor.StringDisplayImpl
import org.junit.Test

class AddtionalTest{
    @Test
    fun addtionalTest(){
        val d1 = Display(StringDisplayImpl("Hello, Japan"))
        val d2:Display = CountDisplay(StringDisplayImpl("Hello, World"))
        val d3 = CountDisplay(StringDisplayImpl("Hello, Universe"))
        d1.display()
        d2.display()
        d3.display()
        d3.multiDisplay(5)
    }
}