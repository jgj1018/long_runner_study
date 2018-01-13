package iterator

interface Iterator {
    abstract fun hasNext(): Boolean
    abstract fun next():Any
}