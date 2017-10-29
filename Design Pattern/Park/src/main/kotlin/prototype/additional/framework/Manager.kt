package prototype.additional.framework

class Manager {

    private val showcase = HashMap<String, Product>()

    fun register(name:String, proto:Product){
        showcase.put(name, proto)
    }

    fun create(protoname: String):Product {
        val p = showcase.get(protoname)
        return p!!.createClone();
    }
}