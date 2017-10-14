package prototype

class Rectangle:Shape() {
    init {
        this.type = "Rectangle"
    }
    override fun draw() {
        println("Inside Rectangle::draw() method.")
    }


}