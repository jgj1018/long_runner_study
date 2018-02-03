package strategypattern.example2

import strategypattern.example2.predicatefactory.PredicateFactory
import strategypattern.example2.resoureces.PredicateType


class Main {
}

fun main(args: Array<String>) {

    var inventory :ArrayList<Apple> = arrayListOf<Apple>(Apple("green", 100),Apple("red", 130),Apple("red", 80),Apple("green", 120))
    var productmanager: ProductManager = ProductManager()
    var predicatefactory: PredicateFactory = PredicateFactory()

   var heavyapples:ArrayList<Apple> = productmanager.filterApples(inventory, predicatefactory.CreatePredicateInstance(PredicateType.HeavyWeight))
   var greenapples:ArrayList<Apple> = productmanager.filterApples(inventory, predicatefactory.CreatePredicateInstance(PredicateType.GreenColor))

    println("HeavyApplesInventory :  ${heavyapples}")
    println("GreenApplesInventory :  ${greenapples}")
}