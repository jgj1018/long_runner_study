package ObserverPattern.observer

import ObserverPattern.Subject

class OctalObserver(subject: Subject):Observer(subject) {
    init {
        this.subject.attach(this)
    }

    override fun update() {
        println("Octal String: ${subject.state.toString(8)}")
    }
}