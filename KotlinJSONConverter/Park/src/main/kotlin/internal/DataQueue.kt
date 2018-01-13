package internal

import java.util.*

class DataQueue<T>:Queue<T> {
    private val dataQueue:Queue<T> = LinkedList()

    override fun poll(): T {
       return dataQueue.poll()
    }

    override fun remove(element: T): Boolean {
        return dataQueue.remove(element)
    }

    override fun remove(): T {
        return dataQueue.remove()
    }

    override val size: Int
        get() = dataQueue.size

    override fun contains(element: T): Boolean {
       return dataQueue.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return dataQueue.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return dataQueue.isEmpty()
    }

    override fun addAll(elements: Collection<T>): Boolean {
        return dataQueue.addAll(elements)
    }

    override fun clear() {
        dataQueue.clear()
    }

    override fun iterator(): MutableIterator<T> {
        return dataQueue.iterator()
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        return dataQueue.removeAll(elements)
    }

    override fun peek(): T {
        return dataQueue.peek()
    }

    override fun element(): T {
        return dataQueue.element()
    }

    override fun add(element: T): Boolean {
        return dataQueue.add(element)
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        return dataQueue.retainAll(elements)
    }

    override fun offer(e: T): Boolean {
        return dataQueue.offer(e)
    }


    fun extractData():String?{
        var tmp:String = ""
        do {
            tmp += dataQueue.remove()
        }while (dataQueue.size != 0)
        if(tmp == "") return null
        return tmp
    }
}