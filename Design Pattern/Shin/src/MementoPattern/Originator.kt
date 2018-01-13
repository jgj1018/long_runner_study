package MementoPattern

class Originator {
    var state:String? = null

    fun saveStateToMemento():Memento {
        return Memento(state!!)
    }

    fun getStateFromMemento(memento: Memento) {
        state = memento.state
    }
}