package factoryPattern.idCardFactory.television

import factoryPattern.idCardFactory.framework.Factory
import factoryPattern.idCardFactory.framework.Product
import factoryPattern.idCardFactory.idcard.IDCard

class TelevisionFactory : Factory() {
    val owners:MutableList<String> = ArrayList()

    override fun createProduct(owner: String): Product {

        return Television(owner)

    }

    override fun registerProduct(product: Product) {
        owners.add((product as Television).owner)
    }

    override fun showOwners() {
        owners.map { owner -> println("$owner is registered to Television Factory") }
    }

}