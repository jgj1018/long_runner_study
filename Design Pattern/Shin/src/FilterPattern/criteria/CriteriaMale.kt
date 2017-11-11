package FilterPattern.criteria

import FilterPattern.Person

class CriteriaMale:Criteria {
    override fun meetCriteria(persons: List<Person>): List<Person> {
        return persons.filter {
            it.gender.equals("MALE", true)
        }.toMutableList()
    }
}