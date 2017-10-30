package builderpattern

//AbstractBuilder
public interface Item {
    public fun name ():String
    public fun packing(): Packing
    public fun price(): Float
}