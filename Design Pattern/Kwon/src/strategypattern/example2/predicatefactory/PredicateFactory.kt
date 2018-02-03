package strategypattern.example2.predicatefactory

import strategypattern.example2.Predicate.AppleGreenColorPredicate
import strategypattern.example2.Predicate.AppleHeavyWeightPredicate
import strategypattern.example2.Predicate.ApplePredicate
import strategypattern.example2.resoureces.PredicateType

class PredicateFactory {

    fun CreatePredicateInstance(predicatetype: PredicateType): ApplePredicate?{
        when(predicatetype){
            PredicateType.GreenColor -> return AppleGreenColorPredicate()
            PredicateType.HeavyWeight -> return AppleHeavyWeightPredicate()
         else ->
             return null
        }
    }
}