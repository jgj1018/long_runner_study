package inner

import java.time.LocalDate
import java.util.*

data class DateObject(override val value:LocalDate):WrappingObject(value=value) {
}