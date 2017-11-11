package decorator.concreteLevel

import decorator.apiLevel.Shape

class Circle : Shape {
    override fun draw() {
        println("Shape: Circle")
    }
}