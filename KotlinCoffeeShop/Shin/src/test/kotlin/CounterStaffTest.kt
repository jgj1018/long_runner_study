import org.junit.jupiter.api.Test
import shop.staff.CounterStaff

class CounterStaffTest {
    @Test
    fun sayMenuTest() {
        val counterStaff = CounterStaff()
        counterStaff.sayMenu()
    }
}