import inner.*
import stream.CsvReader
import stream.CsvStringMaker
import stream.ReachToEOFException
import stream.changeToDateOrNull
import java.lang.reflect.Constructor
import java.time.LocalDate
import java.util.*


class CsvParser(dest:String) {
    val csvReader:CsvReader = CsvReader(dest)
    val valueQueue:Deque<WrappingObject> = LinkedList()
    val csvMaker = CsvStringMaker()


    fun objectToCsvString(obj: Any):String{
        return csvMaker.objectToCsvString(obj)

    }


    /**
    clazz: ClassObject Of Target
    T: Generic type of parameter
     **/
    fun <T> parseFromCsv(clazz: Class<T>): T? {
        getParams()
        val consts = clazz.constructors
        var result: T? = null
        result = parseToObject(consts)
        return result

    }


    fun getParams(): Queue<WrappingObject>? {
        try{
            var data:String?

            while( !csvReader.isEOLOrEOF() ){
                data =csvReader.getData()
                val wrapObject = wrappingObject(data)
                valueQueue.offer(wrapObject)
            }

        }catch (e :ReachToEOFException){
            csvReader.closeReader()

            return null
        }

        csvReader.rewNewState()
        if(valueQueue.isEmpty()){
            return null
        }
        return valueQueue
    }


    private fun <T> parseToObject(consts: Array<out Constructor<*>>?): T? {
        var result:T? = null
        if (consts != null) {
            for (constructor in consts){
                if( constructor.parameterCount == valueQueue.size ){
                     result = makeInstance(constructor) as T
                }else{

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
                            this.recurToParseToObject(type, param)
                        }
                    }
                }
    }


    private fun<T> recurToParseToObject(type:Class<T>, param: WrappingObject):Any?{
        this.valueQueue.addFirst(param)
        return parseToObject(type.constructors)

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





    private fun wrappingObject(rawData:String):WrappingObject{

        if(rawData.toDoubleOrNull() != null){
            return NumberObject(rawData.toDouble())
        }else if(isBooleanType(rawData)){
            return BooleanObject(rawData.toBoolean())
        }else if(rawData.length == 1){
            return CharacterObject(rawData.toCharArray()[0])

        }else if( changeToDateOrNull(rawData)!= null){
            return DateObject(changeToDateOrNull(rawData)!!)
        }else if(rawData.isEmpty()){
            return NullObject()
        }
        else{
            val stringVal = trimString(rawData)
            return StringObject(stringVal)
        }

    }


    private fun isBooleanType(rawData: String):Boolean{
        val raw = rawData.toUpperCase()
        return when (raw){
            "TRUE", "FALSE" -> true
            else -> false
        }
    }


    private fun trimString(rawData: String): String {
        if (rawData.first() != '"' && rawData.last() != '"'){
            return rawData
        }else{
            var trimableString = rawData.substring(1,rawData.length-1)

            try {
                trimableString = changeDuplicatedDoubleQuoteToSingle(trimableString)

            } catch (e : Exception){
                e.printStackTrace()
                throw ReachToEOFException()
            }finally {
            }

            return trimableString
        }


    }


    private fun changeDuplicatedDoubleQuoteToSingle(targetString: String):String{
        return targetString.replace("\"\"","\"")

    }


}