package abstactFactoryPattern.htmlFactory.listfatory

import abstactFactoryPattern.htmlFactory.fatory.Link

class ListLink(caption:String, url:String):Link(caption = caption, url = url) {
    override fun makeHTML(): String {
        return "<li><a href=\"$url\">$caption</a></li>\n"
    }
}