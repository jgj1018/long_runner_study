package PrototypePattern

import PrototypePattern.shapes.Circle
import PrototypePattern.shapes.Rectangle
import PrototypePattern.shapes.Shape
import PrototypePattern.shapes.Square

/**
 * Created by Shin on 2017/10/20.
 */
fun main(args: Array<String>) {
    shapeCache.loadCache()

    val clonedShape = shapeCache.getShape("1")
    clonedShape.draw()

    val clonedShape2 = shapeCache.getShape("2")
    clonedShape2.draw()

    val clonedShape3 = shapeCache.getShape("3")
    clonedShape3.draw()
}

object shapeCache {
    val shapeMap: HashMap<String, Shape> = hashMapOf<String, Shape>()

    fun getShape(shapeId:String):Shape {
        val cachedShape = shapeMap.get(shapeId)
        return cachedShape!!.clone() as Shape
    }

    fun loadCache() {
        val circle = Circle()
        circle.id = "1"
        shapeMap.put(circle.id!!, circle)

        val square = Square()
        square.id = "2"
        shapeMap.put(square.id!!, square)

        val rectangle = Rectangle()
        rectangle.id = "3"
        shapeMap.put(rectangle.id!!, rectangle)

    }
}