package builder

import builder.sentenceBuilder.Director
import builder.sentenceBuilder.impLevel.HTMLBuilder
import builder.sentenceBuilder.impLevel.TextBuilder
import org.junit.Before
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class sentenceBuilderTest {
    lateinit var director:Director
    @Test
    fun testTextBuilder(){
        val textBuilder = TextBuilder()
        director = Director(textBuilder)
        director.construct()
        val result = textBuilder.getResult()
        println(result)
        assertTrue(result.length > 0)
    }
    @Test
    fun testHTMLBuilder(){
    val htmlBuilder = HTMLBuilder()
        director = Director(htmlBuilder)
        director.construct()
        val fliename = htmlBuilder.getResult()
        val file = File("Greeting.html")
        assertEquals("Greeting.html", fliename)
        assertTrue(file.exists())

    }
}