package FactoryPattern

/**
 * Study FactoryPattern
 *
 * Created by Shin on 2017/09/30.
 */
fun main(args: Array<String>) {
    val shapeFactory = ShapeFactory()

    shapeFactory.getShape("Circle")?.draw()
    shapeFactory.getShape("Rectangle")?.draw()
    shapeFactory.getShape("Square")?.draw()
}