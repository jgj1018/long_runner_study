package singleton

object SingleObject {

    fun showMessage(){
        println("helllo${this.hashCode()}")
    }
}