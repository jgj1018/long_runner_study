package bridgePattern.addtionalBridge.implementor

//ConcreteImplementor
//implement implementor
class StringDisplayImpl(private val string:String):DisplayImpl() {
    private val width:Int = string.toByteArray().size
    override fun rawOpen() {
        printLine()
    }

    override fun rawPrint() {
        println("|$string|")
    }

    override fun rawClose() {
        printLine()
    }

    private fun printLine(){
        print("+")
        for (i in 0..width){
            print("-")
        }
        println("+")

    }
}