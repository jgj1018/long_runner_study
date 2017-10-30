package builderpattern

public abstract class ColdDrink : Item{

    override fun packing(): Packing {
        return Bottle()
    }

    override abstract fun price(): Float

}