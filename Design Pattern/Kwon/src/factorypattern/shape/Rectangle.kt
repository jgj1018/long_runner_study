package factorypattern.shape

import factorypattern.`interface`.Shape

class Rectangle : Shape{
    override fun draw() {
        super<Shape>.draw()
    }
}