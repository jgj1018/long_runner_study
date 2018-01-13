import internal.TestObject
import org.junit.Test
import stream.BadJsonFormatException
import stream.JsonBridge
import stream.JsonReader
import kotlin.test.assertEquals

class JsonTester{

    @Test
    fun typeTest(){
        val t = TestObject("PArk", 20);
        var parser = JsonParser("/Users/gring2/workspace/long_runner_study/KotlinJSONConverter/Park/test.txt")
        var resultObject:TestObject = parser.fromJson(t.javaClass)
        assertEquals( t.javaClass,resultObject.javaClass)
    }

    @Test
    fun fillBufferTest(){
        val jsonReader = JsonReader("/Users/gring2/workspace/long_runner_study/KotlinJSONConverter/Park/test.txt")
        val rawText = jsonReader.getData()
        assertEquals('a',rawText)
        val rawText2 = jsonReader.getData()
        assertEquals('b',rawText2)

    }

    @Test(expected=stream.ReachToEOFException::class)
    fun exceptionTest(){
        val jsonReader = JsonReader("/Users/gring2/workspace/long_runner_study/KotlinJSONConverter/Park/test.txt")
        jsonReader.getData()
        jsonReader.getData()
        jsonReader.getData()

    }
    @Test(expected = BadJsonFormatException::class)
    fun quoteTest(){
        val JsonBridge = JsonBridge("/Users/gring2/workspace/long_runner_study/KotlinJSONConverter/Park/quote.txt")
        val rawText = JsonBridge.extractRawData()
    }


    @Test
    fun getKeyTest(){
        val JsonBridge = JsonBridge("/Users/gring2/workspace/long_runner_study/KotlinJSONConverter/Park/test.json")
        val rawText = JsonBridge.extractRawData()
        val rawText1 = JsonBridge.extractRawData()
        val rawText2 = JsonBridge.extractRawData()
        val rawText3 = JsonBridge.extractRawData()
        val rawText4 = JsonBridge.extractRawData()
        val rawText5 = JsonBridge.extractRawData()
        val rawText6 = JsonBridge.extractRawData()
        val rawText7 = JsonBridge.extractRawData()
        val rawText8 = JsonBridge.extractRawData()
        val rawText9 = JsonBridge.extractRawData()


    }

    @Test
    fun getKeynValueTest(){
        val JsonBridge = JsonBridge("/Users/gring2/workspace/long_runner_study/KotlinJSONConverter/Park/test.json")
        JsonBridge.makeKeyandValue()
        assertEquals("\"def\"", JsonBridge.jsonKV.get("abc").toString())

    }
}