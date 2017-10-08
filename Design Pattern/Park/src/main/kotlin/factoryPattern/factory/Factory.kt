package factoryPattern.factory

import factoryPattern.`object`.Shape

interface Factory {

    //Simple Factory
    //Return Type is important
    //implement body is deferred to concrete Class
    fun getShape(shapeType: String): Shape?
}