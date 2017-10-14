package AbstractFactory

fun main(args: Array<String>) {

    val shapeFactory = FactoryProducer.getFactory("SHAPE")

    var shape1 = shapeFactory?.getShape("CIRCLE")
    shape1?.draw()

    var shape2 = shapeFactory?.getShape("RECTANGLE")
    shape2?.draw()

    var shape3 = shapeFactory?.getShape("SQUARE")
    shape3?.draw()

    val colorFactory = FactoryProducer.getFactory("COLOR")

    var color1 = colorFactory?.getColor("RED")
    color1?.fill()

    var color2 = colorFactory?.getColor("Green")
    color2?.fill()

    var color3 = colorFactory?.getColor("BLUE")
    color3?.fill()
}