package Prototype

class Rectangle : Shape() {
    init {
        type = "Rectangle"
    }

    override fun draw() {
        println("Inside Rectangle::draw() method.")
    }
}