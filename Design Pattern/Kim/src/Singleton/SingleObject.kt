package Singleton

// first way
class SingleObject private constructor() {

    object Single {
        private val instance = SingleObject()
        fun getInstance() : SingleObject = instance
    }

    fun showMessage() {
        println("Hello World!"+this.hashCode())
    }
}

// second and more simple way
object SingleObject2 {

    fun showMessage() {
        println("Hello World!"+this.hashCode())
    }
}