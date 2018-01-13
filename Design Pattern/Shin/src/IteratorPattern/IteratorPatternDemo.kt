package IteratorPattern

fun main(args: Array<String>) {
    val namesRepository = NameRepository()

    val iterator = namesRepository.getIterator()

    while (iterator.hasNext()) {
        val name = iterator.next()
        println("Name: $name")
    }
}