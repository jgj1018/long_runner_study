package Prototype

abstract class Shape : Cloneable {

    /*lateinit? Normally, properties declared as having a non-null type must be initialized in the constructor.
    However, fairly often this is not convenient. For example, properties can be initialized through dependency
    injection, or in the setup method of a unit test. In this case, you cannot supply a non-null initializer
    in the constructor, but you still want to avoid null checks when referencing the property inside the body of a class.*/
    lateinit var id: String
    lateinit var type: String

    abstract fun draw()

    public override fun clone(): Any {
        return super.clone()
    }

}