package stream

import com.sun.tools.classfile.Opcode
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import javax.swing.text.DateFormatter
import kotlin.collections.HashSet

val slyyyyMMdd =DateTimeFormatter.ofPattern("yyyy/MM/dd")
val slyymmdd = DateTimeFormatter.ofPattern("yy/mm/dd")


val formatSet: Set<DateTimeFormatter> =
        setOf( DateTimeFormatter.ISO_DATE,slyyyyMMdd, slyymmdd)

fun changeToDateOrNull(rawData:String):LocalDate?{
    var result:LocalDate? = null

    for (format in formatSet){
        try {
            result = LocalDate.parse(rawData,format)

        }catch (e :Exception){

        }

    }

    return result
}