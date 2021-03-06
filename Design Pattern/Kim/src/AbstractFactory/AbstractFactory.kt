package AbstractFactory

abstract class AbstractFactory {

    abstract fun getColor(color: String): Color?
    abstract fun getShape(shape: String): Shape?
}