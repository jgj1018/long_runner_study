package Singleton

class SingleObject private constructor() {

    companion object {
        fun getInstance() = SingleObject()
    }

    fun showMessage() {
        println("Hello World!"+this.hashCode())
    }
}