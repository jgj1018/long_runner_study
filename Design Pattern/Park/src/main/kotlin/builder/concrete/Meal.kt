package builder.concrete

import builder.In.Item
import jdk.nashorn.internal.objects.NativeArray.reduce
import java.util.Optional
import java.util.stream.Stream



class Meal {
    private val items:MutableList<Item> = ArrayList()

    fun addItem(item: Item){
        items.add(item)
    }
    fun getCost():Float{
        var cost =0.0f;
         cost = items.toTypedArray().map { it.price() }.sum()

        return cost

    }

    fun showItems(){
       for (item in items){
           println("Item : ${item.name()}")
           println(", Packing : ${item.packing().pack()}")
           println(", Price : ${item.price()}")

       }
    }
}