package prototype

//Be careful about depth of stack when do deep clone
//shallow clone => val x = Foo()
//                 val y = x

abstract class Shape:Cloneable {
    lateinit var id: String
    lateinit var type:String

    abstract fun draw()

    public override fun clone():Any{
        var clone:Any?=null
        try {
            clone = super.clone()
        }catch (e: CloneNotSupportedException){
            e.printStackTrace();
        }
        return clone!!
    }
}