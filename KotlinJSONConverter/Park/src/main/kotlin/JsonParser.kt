import org.omg.CORBA.Object
import stream.JsonBridge

class JsonParser(private val dest:String) {


    private var PARSINGSTARTED = true
    private val JsonBridge = JsonBridge(dest)

    /**
        clazz: ClassObject Of Target
        T: Generic type of parameter
     **/
    fun <T> fromJson(clazz: Class<T>): T {
        this.parsingStatusChange()

        val const = clazz.constructors
        var result: T? = null
        for (constructor in const){
           if( constructor.parameterCount ==0 ){
               result = constructor.newInstance() as T
           }else{

           }
        }
        return result!!

    }


    private fun parsingStatusChange(){
        this.PARSINGSTARTED = !PARSINGSTARTED
    }

    private fun getJsonDataSet(){
        val rawDataSet = JsonBridge.makeKeyandValue()

    }
}