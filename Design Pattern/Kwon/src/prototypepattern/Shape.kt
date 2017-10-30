package prototypepattern

public abstract class Shape : Cloneable{

    var id : String =""
    //protected var type : String =""
    //Another difference between Java and Kotlin’s visiblity modifier is that Kotlin’s ‘protected’ keyword means the member is only visible in the class and it’s classes
    //protected is not available for top-level declarations.

    var type : String =""
    set(value){
        when(this){
            is Circle -> field = value
            is Square -> field = value
            is Rectangle -> field = value
            else -> ""
        }
    }

    abstract fun draw()

    //Unit void Any Object
    public override fun clone(): Any {
        var clone: Any? = null

        try {
            clone =super.clone()

        }catch ( e:CloneNotSupportedException){
            println(e)
        }
        return clone!!
    }
}