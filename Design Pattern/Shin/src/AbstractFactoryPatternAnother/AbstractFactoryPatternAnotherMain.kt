package AbstractFactoryPatternAnother

/**
 * Created by Shin on 2017/10/05.
 */
fun main(args: Array<String>) {
    val colorFactory = FactoryFactory.createFactory<ColorFactory>()
    val blue = colorFactory.getColor(ColorCategory.Blue)

    val shapeFactory = FactoryFactory.createFactory<ShapeFactory>()
    val circle = shapeFactory.getShape(ShapeCategory.Circle)

}