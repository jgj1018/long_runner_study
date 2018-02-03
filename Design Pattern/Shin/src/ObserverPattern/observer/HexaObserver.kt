package ObserverPattern.observer

import ObserverPattern.Subject

class HexaObserver(subject: Subject):Observer(subject) {
    init {
        this.subject.attach(this)
    }

    override fun update() {
        println("Hex String: ${subject.state.toString(16).toUpperCase()}")
    }
}