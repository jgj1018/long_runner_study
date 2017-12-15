package shop

import menu.Menu
import menu.MenuList
import shop.staff.Barista
import shop.staff.CounterStaff

/**
 * CounterStaff와 Barista가 있을거임
 */
class Shop {
    val pos = POS()
    val counterStaff = CounterStaff(this, pos)
    val barista = Barista()
    val storage = Storage()
    val menuList = MenuList()
}

class POS(var money: Double = 100.0) {

    fun calculatePrice(menu: Menu):Double {
        return menu.getPrice()
    }

    fun depositMoney(money: Double) {
        this.money += money
    }
}