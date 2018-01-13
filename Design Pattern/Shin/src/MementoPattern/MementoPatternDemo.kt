package MementoPattern

fun main(args: Array<String>) {
    val originator = Originator()
    val careTaker = CareTaker()

    originator.state = "State #1"
    originator.state = "State #2"
    careTaker.add(originator.saveStateToMemento())

    originator.state = "State #3"
    careTaker.add(originator.saveStateToMemento())

    originator.state = "State #4"
    println("Current State: ${originator.state}")

    originator.getStateFromMemento(careTaker.get(0))
    println("First Saved State: ${originator.state}")

    originator.getStateFromMemento(careTaker.get(1))
    println("Second Saved State: ${originator.state}")
}