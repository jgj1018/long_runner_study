package json

interface Json {
    val name: String?
    val value: Any?

    override fun toString(): String
}