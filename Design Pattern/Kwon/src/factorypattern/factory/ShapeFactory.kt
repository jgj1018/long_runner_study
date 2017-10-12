package factorypattern.factory

import factorypattern.`interface`.Shape
import factorypattern.shape.Circle
import factorypattern.shape.Rectangle
import factorypattern.shape.Square

public class ShapeFactory{

    public fun getShape(shapeType : String?): Shape?{

        when(shapeType){
            "CIRCLE" -> return Circle()
            "RECTANGLE" -> return Rectangle()
            "SQUARE" -> return Square()
            else -> return null
        }
    }
}