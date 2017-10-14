package Factory

class ShapeFactory {

    fun getShape(shapeType: String?): Shape? {
        if (shapeType == null) {
            return null
        }

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