package Singleton

fun main(args: Array<String>) {

    val obj = SingleObject.Single.getInstance()
    obj.showMessage()

    val obj2 = SingleObject.Single.getInstance()
    obj2.showMessage()

    SingleObject2.showMessage()
    SingleObject2.showMessage()
}
