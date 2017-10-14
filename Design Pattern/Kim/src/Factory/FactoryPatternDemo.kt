package Factory

fun main(args: Array<String>) {
    val shapeFactory = ShapeFactory()

    var shape1 = shapeFactory.getShape("CIRCLE")
    shape1?.draw()

    var shape2 = shapeFactory.getShape("RECTANGLE")
    shape2?.draw()

    var shape3 = shapeFactory.getShape("SQUARE")
    shape3?.draw()
}