package abstactFactoryPattern.factory

fun getFactory(choice: String): AbstractFactory?{

    return when(choice.toUpperCase()){

        "SHAPE" -> ShapeFactory()

        "COLOR" -> ColorFactory()

        else -> null
    }
}