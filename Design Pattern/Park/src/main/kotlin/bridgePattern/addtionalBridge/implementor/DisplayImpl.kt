package bridgePattern.addtionalBridge.implementor

//Implementer
//top of Implementer
//define methods which implements methods of Abstraction
abstract class DisplayImpl {
    abstract fun rawOpen()
    abstract fun rawPrint()
    abstract fun rawClose()
}