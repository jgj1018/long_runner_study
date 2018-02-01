import inner.*
import stream.BadCsvFormatException
import stream.CsvReader
import stream.ReachToEOFException
import stream.changeToDateOrNull
import java.lang.reflect.Constructor
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CsvParser(dest:String) {
    val csvReader:CsvReader = CsvReader(dest)
    val valueQueue:Deque<WrappingObject> = LinkedList()


    /**
    clazz: ClassObject Of Target
    T: Generic type of parameter
     **/
    fun <T> parseFromCsv(clazz: Class<T>): T {
        getParams()
        val consts = clazz.constructors
        var result: T? = null
        result = parseToObject(consts)
        return result!!

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
            val quoteIndexList:MutableList<Int> =  ArrayList()

            var i = 0
            do {

                i =  trimableString.indexOf('"',i)
                if (i != -1){
                    quoteIndexList.add(i)
                }
            }while (i < trimableString.length && i != -1)


            try {
                trimableString = changeDuplicatedDoubleQuoteToSingle(quoteIndexList,trimableString)

            } catch (e : Exception){
                e.printStackTrace()
                throw ReachToEOFException()
            }finally {
            }

            return trimableString
        }


    }



    private fun changeDuplicatedDoubleQuoteToSingle(indexList:List<Int>, targetString: String):String{
        for (i in 1..indexList.size){
            val prevIndex = indexList.get(i -1)
            val prevDubleQuote:String = targetString.get(prevIndex).toString()
            if( targetString.get(prevIndex) == '"'){
                val t = prevDubleQuote+targetString.get(i)
                targetString.replace(t,"\"")
            }else{
                throw BadCsvFormatException()
            }
        }
        return targetString
    }


    private fun parseToParam(constructor: Constructor<*>?):List<Any?> {
        val paramTypes = constructor!!.parameterTypes

        val params = paramTypes
                .map {  parseWrapObject(it, this.valueQueue.remove()) }
        return params
    }


    private fun <T>parseWrapObject(type:Class<T>, param: WrappingObject):Any?{
        if(param is NullObject) return null
        if(type.isPrimitive || type.typeName == "java.lang.String"){
            return parseToPrimative(type.typeName, param)
        }else{

            this.valueQueue.addFirst(param)
            return parseToObject(type.constructors)
        }

    }


    private fun parseToPrimative(typeName:String, param:WrappingObject):Any{
        return when(typeName){

            "java.lang.String" -> param.getVal() as String
            "double" -> param.getVal() as Double
            "char" -> param.getVal() as Char
            "int" -> (param.getVal() as Double).toInt()
            "boolean" -> param.getVal() as Boolean


            else -> {
            }
        }
    }

    private fun  makeInstance(constructor: Constructor<*>): Any {
        val param = parseToParam(constructor)

        val result = constructor.newInstance( *param.toTypedArray())
        return result
    }
}