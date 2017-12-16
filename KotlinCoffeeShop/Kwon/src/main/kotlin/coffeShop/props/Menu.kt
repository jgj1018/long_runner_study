package coffeShop.props

import coffeShop.shopdata.MenuInfo
import coffeShop.shopdata.MenuType

public abstract class Menu {

    abstract  var name : String
    abstract var price : Int
    abstract var discription: String
    abstract var type : String
    abstract  var ingredient : String
}