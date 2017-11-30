package flyweight

class ShapeFactory {



    companion object {
        private val circleMap:MutableMap<String, Shape> = HashMap()

        fun getCircle(color:String):Shape?{
            var circle:Shape? = null
            try {
                circle = circleMap.get(color)!!

            }catch (e:NullPointerException){
                circle = Circle(color)
                circleMap.put(color,circle)
                println("Creating circle of color : $color")
            }finally {
                return circle
            }

        }
    }
}