package json

class PreJsonObject(val name: JsonName, val other: String) {
    override fun toString(): String {
        return "$name , $other"
    }
}