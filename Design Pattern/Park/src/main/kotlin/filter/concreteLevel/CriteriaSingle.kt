package filter.concreteLevel

import filter.aPILevel.Criteria

class CriteriaSingle : Criteria {
    override fun meetCriteria(persons: List<Person>): List<Person> {
        val singleersons:MutableList<Person> = ArrayList()

        for( person in persons){
            if(person.getMaritalStatus().equals("SINGLE",true)){
                singleersons.add(person)
            }
        }
        return singleersons
    }
}