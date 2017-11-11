package FilterPattern.criteria

import FilterPattern.Person

interface Criteria {
    fun meetCriteria(persons:List<Person>): List<Person>
}