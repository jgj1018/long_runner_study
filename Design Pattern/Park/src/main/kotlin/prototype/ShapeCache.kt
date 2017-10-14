package prototype

import java.util.*

class ShapeCache {
   companion object {
        val shapeMap:Hashtable<String, Shape> = Hashtable()
       //not nul, synchronized, thread safe

       fun getShape(shapeId: String):Shape{
           val cachedShape = shapeMap.get(shapeId) ;
           return cachedShape!!.clone() as Shape
       }

       fun loadCache(){
           val circle = Circle()
           circle.id = "1"
           println("Circle Hash code ${circle.hashCode()}")
           shapeMap.put(circle.id, circle)

           val square = Square()
           square.id = "2"
           println("Square Hash code ${square.hashCode()}")

           shapeMap.put(square.id, square)

           val rectangle = Rectangle()
           rectangle.id = "3"
           println("Rectangle Hash code ${rectangle.hashCode()}")

           shapeMap.put(rectangle.id, rectangle)
       }
   }
}