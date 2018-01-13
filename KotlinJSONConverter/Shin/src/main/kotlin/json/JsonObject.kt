package json

/**
 *
 */
class JsonObject(override val name:String, override val value: JsonObject):Json {
    override fun toString(): String {
        return "{$name:$value}"
    }
}