package json

class JsonBoolean(override val name: String, override val value: Boolean):Json {
    override fun toString(): String {
        return "{$name:$value}"
    }
}