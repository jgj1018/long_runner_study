import java.util.*

fun main(args: Array<String>) {
    val t:Queue<Char> = LinkedList()
    t.add('C')
    t.add('h')
    t.add('a')
    t.add('r')
    var y:Char
    val ca = t.reduce { acc, c ->acc+ c.toInt() }

    val cc = arrayOf('C', 'h', 'a', 'r')
    ca.toString()

}