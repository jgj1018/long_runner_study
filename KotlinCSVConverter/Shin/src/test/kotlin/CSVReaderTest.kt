import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CSVReaderTest {
    @Test
    fun readFileTest() {
        val csvReader = CSVReader()
        println(csvReader.readFile())
    }
}