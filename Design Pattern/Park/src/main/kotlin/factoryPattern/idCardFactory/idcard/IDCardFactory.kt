package factoryPattern.idCardFactory.idcard
import factoryPattern.idCardFactory.framework.Factory
import factoryPattern.idCardFactory.framework.Product

class IDCardFactory: Factory() {

    val owners:MutableList<String> = ArrayList()

    override fun createProduct(owner: String): Product {

        return IDCard(owner)

    }

    override fun registerProduct(product: Product) {
        owners.add((product as IDCard).owner)
    }

    override fun showOwners() {
        owners.map { owner -> println("$owner is registered to IDCard Factory") }
    }

}