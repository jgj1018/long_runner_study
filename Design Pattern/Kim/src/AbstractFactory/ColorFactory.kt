package AbstractFactory

class ColorFactory : AbstractFactory() {

    override fun getColor(colorType: String): Color? {
        if (colorType.equals("RED", ignoreCase = true)) {
            return object : Color {
                override fun fill() {
                    println("Inside Red::fill() method.")
                }
            }

        } else if (colorType.equals("GREEN", ignoreCase = true)) {
            return object : Color {
                override fun fill() {
                    println("Inside Green::fill() method.")
                }
            }

        } else if (colorType.equals("BLUE", ignoreCase = true)) {
            return object : Color {
                override fun fill() {
                    println("Inside Blue::fill() method.")
                }
            }
        }

        return null
    }

    override fun getShape(shape: String): Shape? {
        return null
    }
}