package Prototype

class Circle : Shape() {
    init {
        type = "Circle"
    }

    override fun draw() {
        println("Inside Circle::draw() method.")
    }
}