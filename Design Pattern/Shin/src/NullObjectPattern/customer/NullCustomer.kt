package NullObjectPattern.customer

class NullCustomer():AbstractCustomer() {
    override var name: String = ""
        get() {
            return "Not Available in Customer Database"
        }
    override fun isNil(): Boolean = true
}