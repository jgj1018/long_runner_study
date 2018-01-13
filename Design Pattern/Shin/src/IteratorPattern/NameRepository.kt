package IteratorPattern

class NameRepository:Container {
    val names = arrayOf("Robert", "John", "Julie", "Lora")
    override fun getIterator(): Iterator {
        return NameIterator()
    }

    /**
     * 내부 클래스 선언자 inner
     */
    inner class NameIterator:Iterator {
        var index:Int = 0

        override fun hasNext(): Boolean {
            return index < names.size
        }

        override fun next(): Any? {
            if (this.hasNext()) {
                return names[index++]
            }
            return null
        }
    }
}