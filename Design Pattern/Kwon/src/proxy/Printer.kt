package proxy

class Printer : Printable{
    private var name : String = ""

    constructor(){
        if(!this.name.equals(""))
        heavyJob("Printer의 인스턴스 ${name}을 생성중..")
    }
    constructor(name :String):this(){
        this.name = name
        heavyJob("Printer의 인스턴스 ${name}을 생성중..")
    }
    public override fun setPrinterName(name : String){
        this.name = name
    }
    public override fun getPrinterName():String{
        return this.name
    }
    public override fun print(string: String){
        println(" ===  ${name} ===")
        println(string)
    }
    //Printer인스턴스가 무거운 일을 한다고 가정하기위해
    //5초동안 1초에 한번 . 을 출력하는 메소드를 실행한다.
    private fun heavyJob(msg :String){
        println(msg)
        for (x in 1.. 5){
            Thread.sleep(1000)
            println(".")
        }
        println("완료")
    }
}