package Prototype

import java.util.Hashtable

object ShapeCache {

    private val shapeMap = Hashtable<String, Shape>()

    fun getShape(shapeId: String): Shape {
        val cachedShape = shapeMap[shapeId]
        return cachedShape?.clone() as Shape
    }

    fun loadCache() {
        val circle = Circle()
        circle.id = "1"
        shapeMap.put(circle.id, circle)

        val square = Square()
        square.id = "2"
        shapeMap.put(square.id, square)

        val rectangle = Rectangle()
        rectangle.id = "3"
        shapeMap.put(rectangle.id, rectangle)
    }
}