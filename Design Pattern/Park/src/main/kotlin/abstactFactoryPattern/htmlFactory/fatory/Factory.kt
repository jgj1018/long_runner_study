package abstactFactoryPattern.htmlFactory.fatory

//abstract Factory
abstract class Factory {

    companion object {
        fun getFactory(classname: String): Factory?{
            var factory: Factory? = null
            try {
                factory = Class.forName(classname).newInstance() as Factory
            }catch (e: ClassNotFoundException) {
                System.err.println("class $classname is not found")
            } catch (e: Exception){
                e.printStackTrace()
            }

            return factory
        }
    }

    abstract fun createLink(caption: String, url: String):Link
    abstract fun createTray(caption: String):Tray
    abstract fun createPage(title: String, author: String):Page

}