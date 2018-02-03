package strategypattern.example2.Predicate

import strategypattern.example2.Apple

class AppleHeavyWeightPredicate : ApplePredicate {

    override fun checkApple(apple: Apple): Boolean {
        if(apple.weight >= 100){
            return true
        }
        return false
    }
}