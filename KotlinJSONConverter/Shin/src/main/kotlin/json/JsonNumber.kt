package json

class JsonNumber(override val name: String, override val value: Number):Json {
    override fun toString(): String {
        return "{$name:$value}"
    }
}