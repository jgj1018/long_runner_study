package json

class JsonArray(override val name: String, override val value: List<Json>):Json {
    override fun toString(): String {
        return "{$name:$value}"
    }
}