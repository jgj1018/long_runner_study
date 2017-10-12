package abstractfactorypattern.shape

import abstractfactorypattern.`interface`.Shape

class Square : Shape{
    override fun draw(){
        super<Shape>.draw()
    }
}