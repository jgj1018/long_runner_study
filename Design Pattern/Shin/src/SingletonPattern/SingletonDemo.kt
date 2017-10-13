package SingletonPattern

/**
 * Created by Shin on 2017/10/05.
 */
fun main(args: Array<String>) {
    SingleObject.showMessage()
}

object SingleObject{
    init {
        println("Init $this")
    }

    fun showMessage() {
        println("Hello World! $this")
    }
}