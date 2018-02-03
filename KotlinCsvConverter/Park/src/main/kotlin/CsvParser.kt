import exceptions.BadCsvFormatException
import inner.*
import stream.*
import java.lang.reflect.Constructor
import java.time.LocalDate
import java.util.*


class CsvParser(dest:String) {
    val valueWrapper = ValueWrapper(dest)
    var valueQueue:Deque<WrappingObject> = LinkedList()
    val csvMaker = CsvStringMaker()


    fun objectToCsvString(obj: Any):String{
        return csvMaker.objectToCsvString(obj)
    }


    /**
    clazz: ClassObject Of Target
    T: Generic type of parameter
     **/
    fun <T> parseFromCsv(clazz: Class<T>): T? {
        var result: T? = null
        try {
            this.valueQueue = valueWrapper.getParams()!!
            val consts = clazz.constructors
            result = parseToObject(consts)

        }catch (e:NullPointerException){

        }
        finally {
            return result

        }


    }





    private fun <T> parseToObject(consts: Array<out Constructor<*>>?): T? {
        var result:T? = null


        if (consts != null) {
            for (constructor in consts){
                if( constructor.parameterCount == valueQueue.size ){
                     result = makeInstance(constructor) as T
                }else{
                    try{
                        throw BadCsvFormatException()

                    }catch (e : BadCsvFormatException){
                        e.printStackTrace()
                        valueWrapper.close()
                    }
                }
            }
        }


        return result
    }


    private fun  makeInstance(constructor: Constructor<*>): Any {
        val param = parseToParam(constructor)

        val result = constructor.newInstance( *param.toTypedArray())
        return result
    }


    private fun parseToParam(constructor: Constructor<*>?):List<Any?> {
        val paramTypes = constructor!!.parameterTypes

        val params:List<Any?> = paramTypes
                .map {  parseWrapObject(it, this.valueQueue.remove()) }
        return params
    }


    private fun <T>parseWrapObject(type:Class<T>, param: WrappingObject):Any?{
        if(param is NullObject) return null
        return if( type.isPrimitive ){
                parseToPrimative(type.typeName, param)

                }else{
                    when(type.typeName){
                        "java.lang.Integer" -> (param.getVal() as Double).toInt()
                        "java.lang.String" -> param.getVal() as String

                        "java.time.LocalDate" -> param.getVal() as LocalDate
                        else -> {
                        }
                    }
                }
    }




    private fun parseToPrimative(typeName:String, param:WrappingObject):Any{
        return when(typeName){

            "double" -> param.getVal() as Double
            "char" -> param.getVal() as Char
            "int" -> (param.getVal() as Double).toInt()
            "boolean" -> param.getVal() as Boolean


            else -> {
            }
        }
    }








}