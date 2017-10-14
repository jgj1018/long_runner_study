package abstactFactoryPattern.htmlFactory.listfatory

import abstactFactoryPattern.htmlFactory.fatory.Page

class ListPage(title: String, author: String): Page(title = title, author = author) {
    override fun makeHTML(): String {
        val buffer = StringBuffer()
        buffer.append("<html><head><title>$title</title></head>\n")
        buffer.append("<body>\n")
        buffer.append("<h1>$title</h1>\n")
        buffer.append("<ul>\n")
        val it = content.iterator()
        while(it.hasNext()){
            val item = it.next()
            buffer.append(item.makeHTML())
        }

        buffer.append("</ul>\n")
        buffer.append("<hr><address>$author</address>")
        buffer.append("</body></html>\n")
        return buffer.toString()
    }
}