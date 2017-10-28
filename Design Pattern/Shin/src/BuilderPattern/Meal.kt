package BuilderPattern

/**
 * Created by Shin on 2017/10/22.
 */
class Meal {
    val items:MutableList<Item> = mutableListOf()

    fun addItem(item:Item) {
        items.add(item)
    }

    fun getCost():Float {
        return items.map {it.price()}.sum()
    }

    fun showItems() {
        items.forEach {
            println("Item: ${it.name()}, Packing: ${it.packing().pack()}, Price: ${it.price()}")
        }
    }
}