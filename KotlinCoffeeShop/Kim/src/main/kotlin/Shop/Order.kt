package Shop

import kotlin.properties.Delegates

class Order (val order_id: Int, val menu_id: String, val payment: Int, var change: Int = 0) {
    var order_status: Boolean by Delegates.observable(false) {
        prop, old, new ->
        if (new === true) {
            println("The order is successfully done")
        } else {
            println("The order is failed")
        }
    }

}