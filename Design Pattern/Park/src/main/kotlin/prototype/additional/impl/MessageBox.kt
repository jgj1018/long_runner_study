package prototype.additional.impl

import prototype.additional.framework.Product

class MessageBox(private val decochar:String):Product() {

    override fun use(s:String) {
        val length = s.toByteArray().size

        for(i in 0..length){
            print(decochar)
        }
        println("")
        println("$decochar $s $decochar")
        for(i in 0..length+4){
            print(decochar)
        }
        println("")
    }

    override fun createClone(): Product {
        var p:Product? = null;
        try {
            p = super.clone() as Product
        }catch (e: CloneNotSupportedException){
            e.printStackTrace()
        }
        return p!!

    }
}