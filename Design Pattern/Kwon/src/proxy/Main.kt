package proxy

import kotlin.concurrent.thread

fun main(args: Array<String>) {

    (1 ..4).forEach{

    var p : Printable = PrinterProxy("Alice")
    println("이름은 현재  ${p.getPrinterName()} 입니다." )
    p.setPrinterName("Bob")
    println("이름은 현재  ${p.getPrinterName()} 입니다." )
    p.print("call print Hello world.")

    var p2 : Printable = PrinterProxy("Jack")
        
            p.setPrinterName("Alice")
            p2.print("bbbbbbbb")
            p.getPrinterName()
            p.setPrinterName("Jack")
            p2.getPrinterName()
        }

}