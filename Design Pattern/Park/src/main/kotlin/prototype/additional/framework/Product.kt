package prototype.additional.framework

abstract class Product: Cloneable {
    abstract fun use(s:String)
    abstract fun createClone():Product

    override fun clone():Any{
        var clone:Any?=null
        try {
            clone = super.clone()
        }catch (e: CloneNotSupportedException){
            e.printStackTrace();
        }
        return clone!!
    }
}