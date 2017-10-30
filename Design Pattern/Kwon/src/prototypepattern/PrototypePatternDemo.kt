package prototypepattern

private class PrototypePatternDemo(){

}

fun main(args: Array<String>) {
    ShapeCache.loadCache()

    var clonedShape : Shape = ShapeCache.getShape("1") as Shape
    println("Shape : ${clonedShape.type}")

    var clonedShape2 : Shape = ShapeCache.getShape("2") as Shape
    println("Shape : ${clonedShape2.type}")

    var clonedShape3 : Shape = ShapeCache.getShape("3") as Shape
    println("Shape : ${clonedShape3.type}")
}