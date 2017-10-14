package factorypattern.shape

import factorypattern.`interface`.Shape

class Circle : Shape{
    override fun draw() {
        super<Shape>.draw()
    }
}
