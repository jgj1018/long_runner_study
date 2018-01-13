package exception

class InvalidJsonException(message:String):Throwable(message) {
    override fun toString(): String {
        return "$message is invalid Json"
    }
}