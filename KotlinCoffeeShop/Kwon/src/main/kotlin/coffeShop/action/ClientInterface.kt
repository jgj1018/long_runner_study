package coffeShop.action

import coffeShop.props.Menu
import coffeShop.shopdata.MenuInfo

interface ClientInterface {
    public fun CheckMenu(menulist : ArrayList<MenuInfo>)
    public fun Order() : ArrayList<MenuInfo>
    public fun pay(price : Int) : Int
    public fun getChange(change : Int)
    public fun getProduct(product : ArrayList<Menu> )
}