package abstactFactoryPattern.htmlFactory.tableFactory

import abstactFactoryPattern.htmlFactory.fatory.Link

class TableLink(caption:String, url:String):Link(caption = caption, url = url) {
    override fun makeHTML(): String {
        return "<td><a href=\"$url\">$caption</a></td>"
    }
}