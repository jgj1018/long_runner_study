package abstactFactoryPattern.htmlFactory.fatory

import java.io.File
import java.io.FileWriter
import java.io.IOException

//abstract product
abstract class Page(protected val title:String, protected val author:String) {
    protected val content:MutableList<Item> = ArrayList()

    fun add(item:Item){
        content.add(item)
    }

    fun output(){
        try {
            val file = File("$title.html")

            val outputString = this.makeHTML()

            file.printWriter().use { out -> out.print(outputString) }
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

    abstract fun makeHTML():String
}