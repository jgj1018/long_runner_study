package bridgepattern

public class BridgePatternDemo {

}

fun main(args: Array<String>) {
    var redCircle : Shape = Circle(100,100,10, RedCircle())
    var greenCircle : Shape = Circle(100, 100, 10, GreenCircle())

    redCircle.draw()
    greenCircle.draw()
}