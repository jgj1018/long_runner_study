package facade

import facade.additional.PageMaker
import org.junit.Test
import java.io.File
import kotlin.test.assertTrue

class AdditionalFacadeTest {

    @Test
    fun testFacade(){
        PageMaker.makeWelcomePage("gring2@github.com", "Welcome.html")
        val file = File("Welcome.html")
        assertTrue(file.exists())
    }
}