package decotest

class FactoryTest {

}

fun main(args: Array<String>) {

    var charval:Char = "#".toCharArray()[0]

    var test : Display = StringDisplay("hello")
    var test1 : Display = SideBorder(test!!,charval)
    var test2 : Display = FullBorder(test1!!)

    println(test)
    println(test1)
    println(test2)

    test!!.show()
    test1!!.show()
    test2!!.show()
  //  test1!!.show()
  //  test!!.show()

    var charval2:Char = "/".toCharArray()[0]
    var charval3:Char = "*".toCharArray()[0]

    var test4 : Display = SideBorder(
                            FullBorder(
                               FullBorder(
                                  SideBorder(
                                     FullBorder(
                                        StringDisplay("안녕하세요")
                                     )
                                  ,charval3)
                               )
                            )
                           ,charval2)
    test4.show()

}