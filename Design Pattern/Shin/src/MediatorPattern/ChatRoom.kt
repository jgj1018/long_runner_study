package MediatorPattern

import java.util.*

class ChatRoom {
    companion object {
        fun showMessage(user: User, message:String) {
            println("${Date()} [${user.name}] : $message")
        }
    }
}