import exception.InvalidJsonException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Parser2Test {
    @Test
    fun testParseName() {
        val parser2 = Parser2()

        val testString = """{
        "title": "Sample Konfabulator Widget",
        "name": "main_window",
        "width": 500,
        "height": 500
    },"""

        println(parser2.parseName(testString))
    }
}