package factorypattern.shape

import factorypattern.`interface`.Shape

class Square : Shape{
    override fun draw(){
        super<Shape>.draw()
    }
}