package coffeShop

import coffeShop.actor.Client
import coffeShop.actor.Shop
import coffeShop.props.Menu
import coffeShop.shopdata.MenuInfo

fun main(args: Array<String>) {

    var client : Client = Client(2000)
    var shop : Shop = Shop()
    var menulist : ArrayList<MenuInfo> = ArrayList()
    var orderlist : ArrayList<MenuInfo> = ArrayList()
    var product : ArrayList<Menu> = ArrayList()
    var price : Int = 0
    var money : Int = 0
    var change : Int = 0

    //가게가 메뉴표를 준비한다.
    menulist = shop.makeMenuList()
    //손님이 메뉴표를 읽는다.
    client.CheckMenu(menulist)
    //손님이 메뉴를 고르고 주문한다.
    orderlist = client.Order()
    //가게가 주문을 받고 가격을 알려준다.
    price = shop.getOrder(orderlist)
    //손님이 돈을 내민다.
    money = client.pay(price)
    //가게가 받고 거스름돈을 내민다.
    change = shop.getMoney(money)
    //손님이 거스름돈을 받는다.
    client.getChange(change)
    //가게가 주문받은 상품을 만들고 내민다.
    product = shop.makeMenu()
    //손님이 받는다.
    client.getProduct(product)

}