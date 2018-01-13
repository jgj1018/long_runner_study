import exception.InvalidJsonException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParserTest {

    @Test
    fun testTrimWhitespaceAndLineFeed() {
        val parser = Parser()

        val string1 = "\n n "
        val string2 = " \n \t n"
        val string3 = " \n \t n \n\n\n \t"

        assertEquals("n", parser.trimWhitespaceAndLineFeed(string1))
        assertEquals("n", parser.trimWhitespaceAndLineFeed(string2))
        assertEquals("n", parser.trimWhitespaceAndLineFeed(string3))
    }

    @Test
    fun testTrimBrace() {
        val parser = Parser()

        val string1 = "{{}}"
        val string2 = "{ }"

        assertEquals("", parser.trimBrace(string1))
        assertEquals(" ", parser.trimBrace(string2))
    }

    @Test
    fun testValidateFirstAndLastBrace() {
        val parser = Parser()

        val string1 = "{}"

        assertTrue(parser.validateFirstAndLastBrace(string1))
        assertFalse(parser.validateFirstAndLastBrace("{"))
        assertFalse(parser.validateFirstAndLastBrace("}"))
        assertFalse(parser.validateFirstAndLastBrace(" {} "))
    }

    @Test
    fun testValidateFirstDoubleQuotation() {
        val parser = Parser()

        assertTrue(parser.validateFirstDoubleQuotation("\""))
        assertFalse(parser.validateFirstDoubleQuotation(" \""))
    }

    @Test
    fun testFindNamePart() {
        val parser = Parser()

        assertArrayEquals(arrayOf(1, 3, 5), parser.findNamePart("\"123\":123"))
        assertArrayEquals(arrayOf(1, 1, 3), parser.findNamePart("\"1\":123"))
        assertArrayEquals(arrayOf(1, 1, 5), parser.findNamePart("\"1\"  :123"))
    }

    @Test
    fun testFindNamePartException() {
        val parser = Parser()
        assertThrows(InvalidJsonException::class.java, {
            parser.findNamePart("\"1\"\"  :123")
        })

        assertThrows(InvalidJsonException::class.java, {
            parser.findNamePart("\"1\"23\"\"  :123")
        })
    }

    @Test
    fun testFindValueType() {
        val parser = Parser()

        val resultString = parser.findValueType("\"...\"", 0)
        val resultDigit1 = parser.findValueType("1234" , 0)
        val resultDigit2 = parser.findValueType("1234.5678" , 0)
        val resultDigit3 = parser.findValueType("-1234" , 0)
        val resultArray1 = parser.findValueType("[, , , ,]", 0)
        val resultArray2 = parser.findValueType("[, ,[ , , ] , ,]", 0)
        val resultTrue = parser.findValueType(":true", 1)
        val resultFalse = parser.findValueType("false", 0)
        val resultNull = parser.findValueType("null", 0)
        val testString = """{
        "title": "Sample Konfabulator Widget",
        "name": "main_window",
        "width": 500,
        "height": 500
    },"""
        val resultObject = parser.findValueType(testString, 0)

        assertEquals("String", resultString)
        assertEquals("Number", resultDigit1)
        assertEquals("Number", resultDigit2)
        assertEquals("Number", resultDigit3)
        assertEquals("Array", resultArray1)
        assertEquals("Array", resultArray2)
        assertEquals("True", resultTrue)
        assertEquals("False", resultFalse)
        assertEquals("null", resultNull)
        assertEquals("Object", resultObject)
    }

    @Test
    fun testFindSplitIndex() {
        val parser = Parser()
        val testString1 = """{
        "ti,tle": "Sample Konfabulator Widget",
        "name": "main_window",
        "width": 500,
        "height": 500
    },"""
        val testString2 = """{
        "ti,tle": true,
        "name": "main_window",
        "width": 500,
        "height": 500
    },"""

        assertEquals(48, parser.findSplitIndex(testString1))
        assertEquals(24, parser.findSplitIndex(testString2))
    }
}