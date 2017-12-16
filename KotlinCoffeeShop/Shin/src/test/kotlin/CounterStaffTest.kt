import org.junit.jupiter.api.Test
import shop.Shop
import shop.staff.CounterStaff

class CounterStaffTest {
    @Test
    fun sayMenuTest() {
        val shop = Shop()
        val counterStaff = CounterStaff(shop, shop.pos)
        counterStaff.sayMenu()
    }
}