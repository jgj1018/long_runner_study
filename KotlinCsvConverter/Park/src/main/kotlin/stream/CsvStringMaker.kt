package stream

import java.time.LocalDate
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.javaType

class CsvStringMaker {


    /**
     * Use Java reflection to access to private member
     * **/

    fun objectToCsvString(obj: Any):String{
        val kClass = obj::class
        val members = kClass.memberProperties
        return stringBuilder(obj, members)
    }


    private fun stringBuilder(obj:Any, members:Collection<KProperty1<out Any, Any?>>):String{
        var sbuffer = StringBuffer()
        val orderedMemebers = makeOrderedMembers(obj, members)

        orderedMemebers.forEach {p ->
            try {

                p.isAccessible = true//これを設定すると、privateなpropertyも参照できる
                var f = p.call(obj)

                f = trimFieldIfString(p, f)
                f = changeToStringIfDate(p, f)
                if( f == null){
                    f = ""
                }
                sbuffer = sbuffer.append(f)
                sbuffer = sbuffer.append(",")

            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
        return sbuffer.substring(0,sbuffer.length-1)
    }


    private fun makeOrderedMembers(obj:Any, members:Collection<KProperty1<out Any, Any?>>):List<KProperty1<out Any, Any?>>{
        val fieldsOrdered = obj.javaClass.declaredFields.map { it -> it.name }
        val orderedMemebers:MutableList<KProperty1<out Any, Any?>> = fieldsOrdered
                .map { field -> members.first { it.name == field } }
                .toMutableList()
        return orderedMemebers
    }


    private fun trimFieldIfString(p: KProperty1<out Any, Any?>, f: Any?):Any? {
        if( isStringType(p) && f != null){
            return (f as String).replace("\"","\"\"")
        }
        return f
    }


    private fun isStringType(p: KProperty1<out Any, Any?>):Boolean {
        return ( p.returnType.javaType.typeName == "java.lang.String")

    }


    private fun changeToStringIfDate(p: KProperty1<out Any, Any?>, f: Any?):Any? {
        return if ( p.returnType.javaType.typeName =="java.time.LocalDate" &&f != null) {
            val Ldate = (f as LocalDate)
            val year = Ldate.year
            var month = Ldate.monthValue
            val date = Ldate.dayOfMonth

            if(month < 10){
                return "$year/0$month/$date"

            }
            return "$year/$month/$date"
        }else{
            f
        }

    }
}