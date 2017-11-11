package filter.concreteLevel

import filter.aPILevel.Criteria

class AndCriteria(private val criteria: Criteria, private val otherCriteria: Criteria) : Criteria {
    override fun meetCriteria(persons: List<Person>): List<Person> {
        val firstCriteria = criteria.meetCriteria(persons)
        return otherCriteria.meetCriteria(firstCriteria)
    }
}