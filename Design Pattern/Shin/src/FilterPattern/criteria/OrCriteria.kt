package FilterPattern.criteria

import FilterPattern.Person

class OrCriteria(val criteria: Criteria, val otherCriteria: Criteria):Criteria {
    override fun meetCriteria(persons: List<Person>): List<Person> {
        val firstCriteriaItems = criteria.meetCriteria(persons).toMutableList()
        val otherCriteriaItems = otherCriteria.meetCriteria(persons)

        for (person in otherCriteriaItems) {
            if (!firstCriteriaItems.contains(person)) {
                firstCriteriaItems.add(person)
            }
        }

        return firstCriteriaItems.toList()
    }
}