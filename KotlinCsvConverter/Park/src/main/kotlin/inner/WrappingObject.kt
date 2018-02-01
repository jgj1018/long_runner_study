package inner

open class WrappingObject(open val value: Any?){

    open fun getVal():Any? {
        return this.value
    }
}