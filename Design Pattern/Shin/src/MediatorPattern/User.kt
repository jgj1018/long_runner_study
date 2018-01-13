package MediatorPattern

class User(val name:String) {
    fun sendMessage(message:String) {
        ChatRoom.showMessage(this, message)
    }
}