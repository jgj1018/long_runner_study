package Builder

abstract class ColdDrink : Item {

    override fun packing(): Packing {
        return Bottle()
    }

    abstract override fun price(): Float
}