package shop

import order.Order
import shop.staff.Barista
import shop.staff.CounterStaff

/**
 * CounterStaff와 Barista가 있을거임
 */
class Shop {
    val counterStaff = CounterStaff()
    val barista = Barista()
}