package FactoryPatternAnother

/**
 * Created by Shin on 2017/10/01.
 */
interface Shape {
    fun draw():String
}

class Circle: Shape {
    override fun draw():String {
        return "Inside Rectangle::draw() method."
    }
}

class Rectangle: Shape {
    override fun draw():String {
        return "Inside Rectangle::draw() method."
    }
}

class Square: Shape {
    override fun draw():String {
        return "Inside Square::draw() method."
    }
}

enum class Category {
    Circle, Rectangle, Square, Hexagon
}

class ShapeFactory {
    fun getShapeCategory (shape: Category): Shape? {
        when (shape) {
            Category.Circle -> return Circle()
            Category.Rectangle -> return Rectangle()
            Category.Square -> return Square()
            else -> return null
        }
    }
}