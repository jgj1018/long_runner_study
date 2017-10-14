package abstractfactorypattern.shape

import abstractfactorypattern.`interface`.Shape

class Rectangle : Shape{
    override fun draw() {
        super<Shape>.draw()
    }
}