package strategypattern.example2.Predicate

import strategypattern.example2.Apple

interface ApplePredicate {
    fun checkApple(apple: Apple): Boolean
}