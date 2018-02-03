package ObserverPattern.observer

import ObserverPattern.Subject

class BinaryObserver(subject: Subject):Observer(subject) {
    init {
        this.subject.attach(this)
    }

    override fun update() {
        println("Binary String: ${subject.state.toString(2)}")
    }
}