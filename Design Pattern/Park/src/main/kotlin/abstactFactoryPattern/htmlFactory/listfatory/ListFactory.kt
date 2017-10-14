package abstactFactoryPattern.htmlFactory.listfatory

import abstactFactoryPattern.htmlFactory.fatory.*

class ListFactory:Factory() {
    override fun createLink(caption: String, url: String):Link {
        return ListLink(caption, url)
    }

    override fun createTray(caption: String):Tray {
        return ListTray(caption)
    }

    override fun createPage(title: String, author: String):Page {
        return ListPage(title, author)
    }
}