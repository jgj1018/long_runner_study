package strategypattern.example2

import strategypattern.example2.Predicate.ApplePredicate

class ProductManager {

    fun filterApples(inventory: ArrayList<Apple>, p: ApplePredicate?): ArrayList<Apple>{
        var result  = ArrayList<Apple>()

        for (apple in inventory){
            if(p!!.checkApple(apple)){
                result.add(apple)
            }
        }
        return result
    }
}