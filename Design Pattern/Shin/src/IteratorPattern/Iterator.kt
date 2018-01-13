package IteratorPattern

interface Iterator {
    fun hasNext(): Boolean
    fun next():Any?
}