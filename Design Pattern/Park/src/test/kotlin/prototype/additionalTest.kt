package prototype

import org.junit.Before
import org.junit.Test
import prototype.additional.framework.Manager
import prototype.additional.framework.Product
import prototype.additional.impl.MessageBox
import prototype.additional.impl.UnderlinePen
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals

class additionalTest {
    lateinit var managger:Manager
    @Before
    fun makeManager(){
        managger = Manager()
    }
    @Test
    fun stringTest(){
        val messageBox = MessageBox("*")
        val sBox = MessageBox("/")
        val upen = UnderlinePen('~')
        managger.register("strong message", upen)
        managger.register("warning box", messageBox)
        managger.register("slash box", sBox)
        val p1:Product = managger.create("strong message")
        p1.use("Hello World")
        val p2:Product = managger.create("warning box")
        p2.use("Hello World")
        val p3 = managger.create("slash box")
        p3.use("Hello World")

        assertNotEquals(upen, p1)
        assertNotEquals(messageBox, p2)
        assertNotEquals(sBox, p3)

        assertFalse(upen === p1)
        assertFalse(messageBox === p2)
        assertFalse(sBox === p3)

        assertFalse(upen == p1)
        assertFalse(messageBox == p2)
        assertFalse(sBox == p3)

    }
}