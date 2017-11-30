package facade.additional

import java.io.FileInputStream
import java.io.IOException
import java.util.*

class Database private constructor() {

    companion object {

        fun getProperties(dbname: String):Properties{
            val filename = "$dbname.txt"
            val props = Properties()
            try {
                props.load(FileInputStream(filename))
            }catch (e: IOException){
                println("Warning $filename is not found")
            }

            return props
        }
    }
}