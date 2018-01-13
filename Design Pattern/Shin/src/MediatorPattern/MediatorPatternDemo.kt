package MediatorPattern

fun main(args: Array<String>) {
    val robert = User("Robert")
    val john = User("John")

    robert.sendMessage("Hi! John!")
    john.sendMessage("Hello! Robert!")
}