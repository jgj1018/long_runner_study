package abstactFactoryPattern.htmlFactory.tableFactory

import abstactFactoryPattern.htmlFactory.fatory.Factory
import abstactFactoryPattern.htmlFactory.fatory.Link
import abstactFactoryPattern.htmlFactory.fatory.Page
import abstactFactoryPattern.htmlFactory.fatory.Tray

class TableFactory():Factory() {
    override fun createLink(caption: String, url: String): Link {
        return TableLink(caption, url)
    }

    override fun createTray(caption: String): Tray {
        return TableTray(caption)
    }

    override fun createPage(title: String, author: String): Page {
        return TablePage(title, author)
    }
}