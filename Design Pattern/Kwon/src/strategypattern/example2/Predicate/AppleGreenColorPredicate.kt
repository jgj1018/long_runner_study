package strategypattern.example2.Predicate

import strategypattern.example2.Apple
import strategypattern.example2.resoureces.Properties

class AppleGreenColorPredicate : ApplePredicate {

    override fun checkApple(apple: Apple): Boolean {
       if(apple.color.toUpperCase() == Properties.Green.colorname){
           return true
       }
        return false
    }
}