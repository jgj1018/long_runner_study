package factoryPattern.factory

import factoryPattern.`object`.*

class ShapeFactory: Factory{


    override fun getShape(shapeType: String):Shape?{

        return when(shapeType.toUpperCase()){
            "CIRCLE" -> Circle()

            "RECTANGLE" -> Rectangle()

            "SQUARE" -> Square()

            else -> null

        }
    }
}