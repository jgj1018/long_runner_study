package AbstractFactory

class ShapeFactory : AbstractFactory() {

    override fun getColor(color: String): Color? {
        return null
    }

    override fun getShape(shapeType: String): Shape? {
        if (shapeType.equals("CIRCLE", ignoreCase = true)) {
            return object : Shape {
                override fun draw() {
                    println("Inside Circle::draw() method.")
                }
            }

        } else if (shapeType.equals("RECTANGLE", ignoreCase = true)) {
            return object : Shape {
                override fun draw() {
                    println("Inside Rectangle::draw() method.")
                }
            }

        } else if (shapeType.equals("SQUARE", ignoreCase = true)) {
            return object : Shape {
                override fun draw() {
                    println("Inside Square::draw() method.")
                }
            }
        }

        return null
    }
}