package prototype.additional.impl

import prototype.additional.framework.Product

class UnderlinePen(private val ulchar:Char):Product() {
    override fun use(s: String) {
        val length = s.toByteArray().size
        println("\"$s\" ")
        for (i in 0..length){
            print(ulchar)
        }
        println("")
    }

    override fun createClone(): Product {
        var p:Product? = null
        try {
            p = super.clone() as Product
        }catch (e: CloneNotSupportedException){
            e.printStackTrace()
        }
        return p!!
    }
}