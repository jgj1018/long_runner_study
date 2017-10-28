package Prototype

fun main(args: Array<String>) {
    ShapeCache.loadCache()

    try {
        println("Shape : " + ShapeCache.getShape("1").hashCode())
        println("Shape : " + ShapeCache.getShape("2").hashCode())
        println("Shape : " + ShapeCache.getShape("3").hashCode())
        println("Shape : " + ShapeCache.getShape("1").hashCode())
        println("Shape : " + ShapeCache.getShape("2").hashCode())
        println("Shape : " + ShapeCache.getShape("3").hashCode())
        println("Shape : " + ShapeCache.getShape("1").type)
        println("Shape : " + ShapeCache.getShape("2").type)
        println("Shape : " + ShapeCache.getShape("3").type)
    } catch (e: CloneNotSupportedException) {
        e.printStackTrace()
    }

}
