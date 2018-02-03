package ObserverPattern

import ObserverPattern.observer.Observer

class Subject {
    val observers = mutableListOf<Observer>()
    var state: Int = 0

    /**
     *
     * set() {
     *
     * } <- 이게 잘 안되는데...
     */
    fun setStateValue(value: Int) {
        state = value
        notifyAllObservers()
    }

    fun attach(observer: Observer) {
        observers.add(observer)
    }

    private fun notifyAllObservers() {
        observers.forEach {
            it.update()
        }
    }
}