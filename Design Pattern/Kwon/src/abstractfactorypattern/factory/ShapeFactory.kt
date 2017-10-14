package abstractfactorypattern.factory

import abstractfactorypattern.`interface`.Color
import abstractfactorypattern.`interface`.Shape
import abstractfactorypattern.shape.Circle
import abstractfactorypattern.shape.Rectangle
import abstractfactorypattern.shape.Square

public class ShapeFactory : AbstractFactory(){

    override fun getColor(color: String?): Color? = null
    override fun getShape(shape : String?): Shape? =
            when(shape){
                "CIRCLE" ->  Circle()
                "RECTANGLE" ->  Rectangle()
                "SQUARE" ->  Square()
                 else ->  null
            }
}