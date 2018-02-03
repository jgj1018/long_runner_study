package ObserverPattern.observer

import ObserverPattern.Subject

abstract class Observer(protected var subject:Subject) {
    abstract fun update()
}