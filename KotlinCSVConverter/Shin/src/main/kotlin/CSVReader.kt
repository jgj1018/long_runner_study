import java.io.File
import kotlin.io.*

class CSVReader {
    fun readFile():String {
        return CSVReader::class.java.getResource("sample.csv").readText()
    }
}