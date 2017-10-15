package AbstractFactory

class ShapeFactory : AbstractFactory() {

    override fun getColor(color: String): Color? {
        return null
    }

    override fun getShape(shapeType: String): Shape? {

        return when (shapeType.toUpperCase()) {
            "CIRCLE"    -> Circle()
            "RECTANGLE" -> Rectangle()
            "SQUARE"    -> Square()
            else        -> null
        }
    }
}