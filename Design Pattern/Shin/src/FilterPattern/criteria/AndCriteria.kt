package FilterPattern.criteria

import FilterPattern.Person

class AndCriteria(val criteria: Criteria, val otherCriteria: Criteria):Criteria {
    override fun meetCriteria(persons: List<Person>): List<Person> = otherCriteria.meetCriteria(criteria.meetCriteria(persons))
}