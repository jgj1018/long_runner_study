package builderpattern

//concreate Builder
public abstract class Burger : Item {

    override fun packing(): Packing {
        return Wrapper()
    }

    override abstract fun price(): Float

}