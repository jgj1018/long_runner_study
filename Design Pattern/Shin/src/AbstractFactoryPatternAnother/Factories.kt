package AbstractFactoryPatternAnother

/**
 * Created by Shin on 2017/10/05.
 */
interface Color
class Red : Color
class Green : Color
class Blue : Color

interface Shape
class Circle : Shape
class Rectangle : Shape
class Square : Shape

enum class ShapeCategory {
    Circle, Rectangle, Square, Hexagon
}

enum class ColorCategory {
    Blue, Green, Red, Black
}


interface Factory {
    fun getColor(colorCategory: ColorCategory): Color?
    fun getShape(shapeCategory: ShapeCategory): Shape?
}

class ColorFactory:Factory {
    override fun getColor(colorCategory: ColorCategory): Color? {
        when (colorCategory) {
            ColorCategory.Blue -> return Blue()
            ColorCategory.Green -> return Green()
            ColorCategory.Red -> return Red()
            else -> return null
        }
    }

    override fun getShape(shapeCategory: ShapeCategory): Shape? {
        return null
    }
}

class ShapeFactory:Factory {
    override fun getShape(shapeCategory: ShapeCategory): Shape? {
        when (shapeCategory) {
            ShapeCategory.Circle -> return Circle()
            ShapeCategory.Rectangle -> return Rectangle()
            ShapeCategory.Square -> return Square()
            else -> return null
        }
    }

    override fun getColor(colorCategory: ColorCategory): Color? {
        return null
    }

}

abstract class FactoryFactory {
    abstract fun makeFactory(): Factory

    companion object {
        inline fun <reified T : Factory> createFactory(): Factory = when (T::class) {
            ColorFactory::class -> ColorFactory()
            ShapeFactory::class -> ShapeFactory()
            else -> throw IllegalArgumentException()
        }

    }
}