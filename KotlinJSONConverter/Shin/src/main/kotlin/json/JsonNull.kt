package json

class JsonNull(override val name: String?, override val value: Nothing):Json {
    override fun toString(): String {
        return "{$name:$value}"
    }
}