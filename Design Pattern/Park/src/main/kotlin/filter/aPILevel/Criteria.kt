package filter.aPILevel

import filter.concreteLevel.Person

interface Criteria {
    fun meetCriteria(persons:List<Person>):List<Person>
}