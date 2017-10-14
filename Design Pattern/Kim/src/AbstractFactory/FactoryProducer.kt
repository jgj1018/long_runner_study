package AbstractFactory

object FactoryProducer {
    fun getFactory(choice: String): AbstractFactory? {

        if (choice.equals("SHAPE", ignoreCase = true)) {
            return ShapeFactory()

        } else if (choice.equals("COLOR", ignoreCase = true)) {
            return ColorFactory()
        }

        return null
    }
}
