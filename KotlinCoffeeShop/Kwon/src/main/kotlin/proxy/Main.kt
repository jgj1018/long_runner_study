package proxy

import kotlin.concurrent.thread

fun main(args: Array<String>) {


    var p : Printable = PrinterProxy("Alice")
    println("이름은 현재  ${p.getPrinterName()} 입니다." )
    p.setPrinterName("Bob")
    println("이름은 현재  ${p.getPrinterName()} 입니다." )
    p.print("call print Hello world.")
}