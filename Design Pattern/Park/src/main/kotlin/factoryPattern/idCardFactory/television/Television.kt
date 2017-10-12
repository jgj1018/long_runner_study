package factoryPattern.idCardFactory.television

import factoryPattern.idCardFactory.framework.Product

class Television(val owner: String): Product() {
    init {
        println("$owner's Television is created.")
    }
    override fun use() {
        println("$owner's Television is turned on")
    }

//    fun getOwner():String {
//        return this.owner
//    }
}