package proxy

class PrinterProxy() : Printable {
    var name : String = "" //이름
    var real : Printer? = null //본인

    constructor(name : String) : this() {
        this.name = name
    }

    public override fun setPrinterName(name: String) {
        synchronized(this) {
            if (real != null){
                real?.setPrinterName(name)
            }
            this.name = name;
        }
    }

    override fun getPrinterName(): String {
        return name
    }

    //proxy가 대리인으로서 할 수 있는 범주를 벗어나기 때문에 realize를 호출해서 printer본인을 생성
    //생성한 printer 에게 print 역할을 위임
    override fun print(string: String) {
        realize()
        real?.print(string)
    }

    private fun realize(){
        synchronized(this) {
            if (real == null) {
                real = Printer(name)
            }
        }
    }
}