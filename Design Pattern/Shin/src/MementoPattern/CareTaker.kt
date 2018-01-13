package MementoPattern

class CareTaker {
    val mementoList = mutableListOf<Memento>()

    fun add(state: Memento) {
        mementoList.add(state)
    }

    fun get(index: Int):Memento {
        return mementoList[index]
    }
}