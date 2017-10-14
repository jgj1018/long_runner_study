package abstactFactoryPattern.htmlFactory.fatory

//abstract component
abstract class Item(protected val caption: String) {

    abstract fun makeHTML(): String
}