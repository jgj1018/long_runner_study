package bridgePattern.addtionalBridge.functional

import bridgePattern.addtionalBridge.implementor.DisplayImpl

//Abstraction
//top of functional classes
//use methods of implementor class
//only basic functions are written
open class Display(private val impl:DisplayImpl) {
    fun open(){
        impl.rawOpen()
    }
    fun print(){
        impl.rawPrint()
    }
    fun close(){
        impl.rawClose()
    }

    fun display(){
        open()
        print()
        close()
    }

}