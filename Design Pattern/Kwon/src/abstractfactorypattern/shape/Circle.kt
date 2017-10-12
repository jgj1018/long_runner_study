package abstractfactorypattern.shape

import abstractfactorypattern.`interface`.Shape

class Circle : Shape{
    override fun draw() {
        super<Shape>.draw()
    }
}
