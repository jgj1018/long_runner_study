package decorator.concreteLevel

import decorator.apiLevel.Shape

class Rectangle:Shape{
    override fun draw() {
        println("Shape: Rectangle")
    }
}