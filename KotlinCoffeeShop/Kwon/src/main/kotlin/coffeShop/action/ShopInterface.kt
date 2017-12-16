package coffeShop.action

import coffeShop.props.Menu
import coffeShop.shopdata.MenuInfo

interface ShopInterface {

    public fun makeMenuList() : ArrayList<MenuInfo>
    public fun sayHello()
    public fun getOrder(orderlist : ArrayList<MenuInfo>): Int
    public fun getMoney(moeny : Int) : Int
    public fun makeMenu() : ArrayList<Menu>
}