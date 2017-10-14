package abstactFactoryPattern.htmlFactory.fatory

//abstract component
abstract class Tray(caption: String):Item(caption = caption) {
    protected val tray:MutableList<Item> = ArrayList()

    fun add(item: Item){
        tray.add(item)
    }
}