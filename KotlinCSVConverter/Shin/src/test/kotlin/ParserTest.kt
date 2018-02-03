import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParserTest {
    @Test
    fun makeObjectTest() {
        val csvReader = CSVReader()
        val rawString = csvReader.readFile()
        val parser = Parser()
        parser.makeObject(rawString)
    }

    @Test
    fun makeObjectTest2() {
        val rawString = "\"\"\"\", 1\n, \"\"\"\", 1"
        val parser = Parser()
        parser.makeObject(rawString)
    }
}