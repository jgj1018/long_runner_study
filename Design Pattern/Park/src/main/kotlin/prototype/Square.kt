package prototype

class Square : Shape() {
    init {
        this.type = "Square"
    }
    override fun draw() {
        println("Inside Square::draw() method.")
    }


}