package prototype

class Circle : Shape() {
    init {
        this.type = "Circle"
    }
    override fun draw() {
        println("Inside Circle::draw() method.")
    }


}