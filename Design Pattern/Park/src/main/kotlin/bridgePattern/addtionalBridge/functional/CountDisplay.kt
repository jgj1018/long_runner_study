package bridgePattern.addtionalBridge.functional

import bridgePattern.addtionalBridge.implementor.DisplayImpl

//RefinedAbstraction
//add another function to Abstraction
class CountDisplay(displayImpl: DisplayImpl):Display(impl = displayImpl) {

    fun multiDisplay(times:Int){
        open()
        for (i in 0..times){
            print()
        }
        close()
    }
}