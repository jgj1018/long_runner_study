package ObserverDelegation

/**
 * https://kotlinlang.org/docs/reference/delegated-properties.html
 */
fun main(args: Array<String>) {
    val user = User()
    user.name = "first"
    user.name = "second"
}

/*
<No name> -> first
first -> second
 */