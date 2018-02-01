package stream

import org.junit.Before
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import java.io.File
import CsvParser
import inner.*
import org.junit.Assert
import org.junit.Test
import java.util.*

class csvParserTest {

    lateinit var csvParser: CsvParser
    @Rule
    @JvmField
    val folder: TemporaryFolder = TemporaryFolder()
    lateinit var file: File


    fun prepareReader(){
        file = folder.newFile("new.csv")

        csvParser = CsvParser(file.absolutePath)
    }

    @Test
    fun getDataTest(){
        prepareReader()
        file.writeText("123,1989/05/24, \n \"TEST\"")
        csvParser.getParams()
        val first:NumberObject = csvParser.valueQueue.remove() as NumberObject
        val second:DateObject =  csvParser.valueQueue.remove() as DateObject
        csvParser.valueQueue.remove()
        csvParser.getParams()

        val third:StringObject =  csvParser.valueQueue.remove() as StringObject
        csvParser.getParams()

        Assert.assertEquals(123.0, first.value, Double.MAX_VALUE)
        Assert.assertEquals(1989, second.value.year)
        Assert.assertEquals(5, second.value.monthValue)
        Assert.assertEquals(24, second.value.dayOfMonth)

        Assert.assertEquals("TEST", third.value)
    }

    @Test
    fun allNullObjectTest(){
        prepareReader()
        file.writeText(",,,")
        csvParser.getParams()
        Assert.assertEquals(3,csvParser.valueQueue.size)

        val first = csvParser.valueQueue.remove()
        val second = csvParser.valueQueue.remove()
        val third = csvParser.valueQueue.remove()

        Assert.assertTrue(first is NullObject)
        Assert.assertTrue(second is NullObject)
        Assert.assertTrue(third is NullObject)

    }

    @Test
    fun parseToInstance(){
        prepareReader()
        file.writeText("10, \"Test\", True")

        val result = csvParser.parseFromCsv(TestObject::class.java)
        Assert.assertEquals(10 , result.iValue)
        Assert.assertEquals("Test" , result.sValue)
        Assert.assertEquals(true , result.bvalue)

    }


}