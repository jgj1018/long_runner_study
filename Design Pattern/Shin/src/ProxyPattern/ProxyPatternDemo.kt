package ProxyPattern

fun main(args: Array<String>) {
    val image:Image = ProxyImage("test_10mb.jpg")

    image.display()
    println()
    image.display()
}