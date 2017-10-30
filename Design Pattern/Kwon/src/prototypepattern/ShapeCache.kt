package prototypepattern

import java.util.*

public class ShapeCache {


    companion object{
        // ? 문법오류발생X !! NPE
        private var shapeMap : Hashtable<String, Shape>? = Hashtable<String, Shape>()
        public fun getShape (shapeId : String) : Shape {
            var cachedShape: Shape? = shapeMap?.get(shapeId)
            return cachedShape!!.clone() as Shape
        }

        // for each shape run database query and create shape
        // shapeMap.put(shapeKey, shape);
        // for example, we are adding three shapes

        public fun loadCache():Unit{
            var circle : Circle = Circle()
            circle.id = "1"
            shapeMap!!.put(circle.id, circle)

            var square = Square()
            square.id = "2"
            shapeMap!!.put(square.id, square)

            var rectangle = Rectangle()
            rectangle.id = "3"
            shapeMap!!.put(rectangle.id, rectangle)
        }
    }
}