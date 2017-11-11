package filter.concreteLevel

import filter.aPILevel.Criteria

class OrCriteria(private val criteria: Criteria, private val otherCriteria: Criteria) : Criteria {
    override fun meetCriteria(persons: List<Person>): List<Person> {
        val firstItems = criteria.meetCriteria(persons) as MutableList<Person>
        val otherItems = otherCriteria.meetCriteria(persons) as MutableList<Person>

        otherItems
                .filterNot { firstItems.contains(it) }
                .forEach { firstItems.add(it) }
        return firstItems
    }
}