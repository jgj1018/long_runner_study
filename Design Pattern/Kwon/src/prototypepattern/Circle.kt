package prototypepattern

public class Circle : Shape(){

    init {
        type = "Cirecle"
    }

    override fun draw() {
        println("Inside Circle :: draw() method")
    }
}
