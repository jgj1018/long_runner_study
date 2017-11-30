package menu

interface Menu {
    val menuName: MenuName
    val price:Double
}

abstract class standardMenu(override val menuName: MenuName, override val price: Double): Menu {

}

data class Espresso(override val menuName:MenuName = MenuName("Espresso"), override var price: Double = 1.00) :standardMenu(MenuName("Espresso"), 1.00)
data class CaffeLatte(override val menuName:MenuName = MenuName("CaffeLatte"), override var price: Double = 1.00) :standardMenu(MenuName("CaffeLatte"), 1.00)
data class Cappuchino(override val menuName:MenuName = MenuName("Cappuchino"), override var price: Double = 1.00) :standardMenu(MenuName("Cappuchino"), 1.00)
data class Americano(override val menuName:MenuName = MenuName("Americano"), override var price: Double = 1.00) :standardMenu(MenuName("Americano"), 1.00)

class MenuName(private var name:String) {
    override fun toString(): String {
        return name
    }

    override fun equals(other: Any?): Boolean {
        return this.name == (other as MenuName).name
    }
}

enum class menus(menu: Menu) {
    Espresso(menu.Espresso()),
    CaffeLatte(menu.CaffeLatte()),
    Cappuchino(menu.Cappuchino()),
    Americano(menu.Americano())
}