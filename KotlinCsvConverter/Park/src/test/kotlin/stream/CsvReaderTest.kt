package stream

import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File


class CsvReaderTest{
    lateinit var csvReader: CsvReader
    @Rule @JvmField
    val folder:TemporaryFolder = TemporaryFolder()
    lateinit var file:File
    @Before
    fun prepareReader(){
        file = folder.newFile("new.csv")

        csvReader = CsvReader(file.absolutePath)
    }
    @Test
    fun getDataTest(){
        file.writeText("123,1989/05/24, \n \"TEST\"")
        Assert.assertEquals("123", csvReader.getData())
        Assert.assertEquals("1989/05/24", csvReader.getData())
        Assert.assertEquals("TEST", csvReader.getData())
    }

    @Test
    fun getCommaValueTest(){
        file.writeText("\"T FF\",1")
        Assert.assertEquals("T FF", csvReader.getData())

    }

    @Test
    fun getDoubleQuoteValueTest(){
        file.writeText("\"\"Test\"\"")
        Assert.assertEquals("\"Test\"", csvReader.getData())

    }

    @Test
    fun getDoubleQuoteAndCommaValueTest(){
        file.writeText("\"\"Test, T\"\",1")
        Assert.assertEquals("\"Test, T\"", csvReader.getData())

    }
    @Test
    fun getNumber(){
        file.writeText("133")
        Assert.assertEquals("133", csvReader.getData())

    }


    @Test
    fun getOnlyDoubleQuoteTest(){
        file.writeText("2018/01/14,\",\",,,\" \"\" \"")
        csvReader.getData()
        Assert.assertEquals(",", csvReader.getData())
        csvReader.getData()
        csvReader.getData()

        Assert.assertEquals(" \"\" ", csvReader.getData())

    }


    @Test
    fun getFirstRow(){
        file.writeText("가계부,,,")
        Assert.assertEquals("가계부", csvReader.getData())
        Assert.assertEquals("", csvReader.getData())
        Assert.assertEquals("", csvReader.getData())

    }

    @Test
    fun getWithLineFeedTest(){
        file.writeText("2018/01/14,\",\",,,\" \"\" \"\n2018/01/15")
        Assert.assertEquals("2018/01/14", csvReader.getData())
        Assert.assertEquals(",", csvReader.getData())
        Assert.assertEquals("", csvReader.getData())
        Assert.assertEquals("", csvReader.getData())

        Assert.assertEquals(" \"\" ", csvReader.getData())
        Assert.assertEquals("2018/01/15", csvReader.getData())

    }
}