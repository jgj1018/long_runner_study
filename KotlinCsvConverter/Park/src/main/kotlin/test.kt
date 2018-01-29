import stream.CsvReader

fun main(args: Array<String>) {
    val csvReader = CsvReader("sample.csv")
    var t:String = ""
    try{
        while (!t.equals( '\u0000')){
            t =  csvReader.getData()
            println(t)
        }

    }catch (e:Exception){

    }

}