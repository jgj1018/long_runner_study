package factoryPattern.idCardFactory.idcard

import factoryPattern.idCardFactory.framework.Product

class IDCard(val owner: String): Product() {
    init {
        println("$owner's card is created.")
    }
    override fun use() {
        println("$owner's card is used")
    }

//    fun getOwner():String {
//        return this.owner
//    }
}