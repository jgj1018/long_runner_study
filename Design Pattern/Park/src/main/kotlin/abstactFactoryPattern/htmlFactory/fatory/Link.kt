package abstactFactoryPattern.htmlFactory.fatory

//abstract component
abstract class Link(protected val url:String, caption:String): Item(caption = caption) {

}