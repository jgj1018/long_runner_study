package stream

import inner.*
import java.util.*

class ValueWrapper(dest:String) {
    val csvReader:CsvReader = CsvReader(dest)
    val valueQueue:Deque<WrappingObject> = LinkedList()

    fun getParams(): Deque<WrappingObject>? {
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

            try {
                trimableString = changeDuplicatedDoubleQuoteToSingle(trimableString)

            }catch (e : BadCsvFormatException){
                e.printStackTrace()
            }
            catch (e : Exception){
                e.printStackTrace()
                throw ReachToEOFException()
            }finally {
            }

            return trimableString
        }


    }


    private fun changeDuplicatedDoubleQuoteToSingle(targetString: String):String{
        if (isBadDuobleQuoteFormat(targetString)){
            throw BadCsvFormatException()
        }
        return targetString.replace("\"\"","\"")

    }

    private fun isBadDuobleQuoteFormat(targetString: String): Boolean {
        val quoteIndexList:MutableList<Int> =  ArrayList()

        var i = 0
        do {

            i =  targetString.indexOf('"',i)
            if (i != -1){
                quoteIndexList.add(i)
                i++
            }
        }while (i < targetString.length && i != -1)

        return (quoteIndexList.size % 2 != 0)

    }

}