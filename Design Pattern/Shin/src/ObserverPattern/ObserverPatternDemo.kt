package ObserverPattern

import ObserverPattern.observer.BinaryObserver
import ObserverPattern.observer.HexaObserver
import ObserverPattern.observer.OctalObserver

fun main(args: Array<String>) {
    val subject = Subject()

    HexaObserver(subject)
    OctalObserver(subject)
    BinaryObserver(subject)

    println("First state change: 15")
    subject.setStateValue(15)
    println("Second state change: 10")
    subject.setStateValue(10)
}