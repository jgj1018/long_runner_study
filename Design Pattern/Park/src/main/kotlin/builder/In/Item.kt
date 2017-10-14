package builder.In

interface Item {
    fun name():String
    fun packing(): Packing
    fun price():Float
}