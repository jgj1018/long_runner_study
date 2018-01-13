import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>)
{
    val inputStream = File(Paths.get("").toAbsolutePath().toString()
            .plus("/src/main/resources/example.json")).inputStream()
    val jsonString = inputStream.bufferedReader().use { it.readText() }
    val converter = JsonConverter(jsonString)

    converter.convertJsonToArray()
    //converter.convertObjectToJson()
}