package FactoryPattern

/**
 * ShapeFactory
 *
 * Created by Shin on 2017/09/30.
 */
class ShapeFactory {
    fun getShape(shapeType: String): Shape? {
        when (shapeType) {
            "Circle" -> return Circle()
            "Rectangle" -> return Rectangle()
            "Square" -> return Square()
            else -> return null
        }
    }
}