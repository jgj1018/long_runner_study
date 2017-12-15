package ProxyPattern

interface Image {
    fun display()
}

class RealImage(var fileName: String):Image {
    init {
        loadFromDisk(fileName)
    }

    override fun display() {
        println("Displaying $fileName")
    }

    private fun loadFromDisk(fileName:String) {
        println("Loading $fileName" )
    }
}

class ProxyImage(var fileName: String):Image {
    private var realImage:RealImage? = null

    override fun display() {
        if (realImage == null) {
            realImage = RealImage(fileName)
        }
        realImage!!.display()
    }
}