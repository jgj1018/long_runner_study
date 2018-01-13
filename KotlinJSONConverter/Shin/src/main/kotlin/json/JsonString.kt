package json

class JsonString(override val name: String, override val value: String):Json {
    override fun toString(): String {
        return "{$name:$value}"
    }
}