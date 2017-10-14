package abstactFactoryPattern.htmlFactory.tableFactory

import abstactFactoryPattern.htmlFactory.fatory.Tray

class TableTray(caption: String):Tray(caption = caption) {
    override fun makeHTML(): String {
        val buffer = StringBuffer()
        buffer.append("<td>")
        buffer.append("<table width=\"100%\" border=\"1\"></tr>")
        buffer.append("<td bgcolor=\"#ccc\" align=\"center\" colspan=\"${tray.size}\"><b>$caption</b></td>")
        buffer.append("</tr>\n")
        buffer.append("<tr>\n")
        val it = tray.iterator()
        while(it.hasNext()){
            val item = it.next()
            buffer.append(item.makeHTML())
        }
        buffer.append("</tr></table>")
        buffer.append("</td>")
        return buffer.toString()
    }
}