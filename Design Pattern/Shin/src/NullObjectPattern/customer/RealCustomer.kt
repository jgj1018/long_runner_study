package NullObjectPattern.customer

class RealCustomer(override var name: String):AbstractCustomer() {
    override fun isNil(): Boolean = false
}