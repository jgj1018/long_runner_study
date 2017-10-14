package abstactFactoryPattern.htmlFactory

import abstactFactoryPattern.htmlFactory.fatory.Factory
import abstactFactoryPattern.htmlFactory.listfatory.ListFactory
import abstactFactoryPattern.htmlFactory.tableFactory.TableFactory

fun main(args: Array<String>) {
    val factory = Factory.getFactory(TableFactory::class.qualifiedName!!)
    val asahi = factory!!.createLink("ASAHI newspaper", "http://www.asahi.com/")
    val yomiuri = factory.createLink("YUMIURI newspaper", "http://www.yomiuri.co.jp/")
    val us_yahoo = factory.createLink("Yahoo","http://www.yahoo.com")
    val jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/")
    val excite = factory.createLink("Excite", "http://www.excite.com/")
    val google = factory.createLink("Google", "http://www.google.com/")

    val trayNews = factory.createTray("newsPaper")
    trayNews.add(asahi)
    trayNews.add(yomiuri)
    val trayYahoo = factory.createTray("Yahoo")
    trayYahoo.add(us_yahoo)
    trayYahoo.add(jp_yahoo)

    val traySearch = factory.createTray("SearchEngine")
    traySearch.add(trayYahoo)
    traySearch.add(excite)
    traySearch.add(google)

    val page = factory.createPage("LinkPage", "Gring2")
    page.add(trayNews)
    page.add(traySearch)
    page.output()
}