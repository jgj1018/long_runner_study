package FactoryPatternAnother

/**
 * https://github.com/dbacinski/Design-Patterns-In-Kotlin#factory-method 방식으로
 *
 * Created by Shin on 2017/10/01.
 */
fun main(args: Array<String>) {
    val noShape = "No Shape Code"
    val circleDrawing = ShapeFactory().getShapeCategory(Category.Circle)?.draw()?: noShape
    println(circleDrawing)
    val rectangleDrawing = ShapeFactory().getShapeCategory(Category.Rectangle)?.draw()?: noShape
    println(rectangleDrawing)
    val squareDrawing = ShapeFactory().getShapeCategory(Category.Square)?.draw()?: noShape
    println(squareDrawing)
    val hexagonDrawing = ShapeFactory().getShapeCategory(Category.Hexagon)?.draw()?: noShape
    println(hexagonDrawing)
}