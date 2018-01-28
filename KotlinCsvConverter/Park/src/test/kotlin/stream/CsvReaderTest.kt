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
        file.writeText("1,1989/05/24, \"TEST\"")
        Assert.assertEquals("1", csvReader.getData())
        Assert.assertEquals("1989/05/24", csvReader.getData())
        Assert.assertEquals("TEST", csvReader.getData())

    }
}