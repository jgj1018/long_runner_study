package NullObjectPattern.factory

import NullObjectPattern.customer.AbstractCustomer
import NullObjectPattern.customer.NullCustomer
import NullObjectPattern.customer.RealCustomer

class CustomerFactory {
    companion object {
        val names = arrayOf("Rob", "Joe", "Julie")

        fun getCustomer(name: String):AbstractCustomer {

            names.forEach {
                if (it.equals(name, true)) {
                    return RealCustomer(name)
                }
            }
            return NullCustomer()
        }
    }
}