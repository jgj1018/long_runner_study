package FilterPattern.criteria

import FilterPattern.Person

class CriteriaFemale:Criteria {
    override fun meetCriteria(persons: List<Person>): List<Person> {
        return persons.filter {
            it.gender.equals("FEMALE", true)
        }.toMutableList()
    }
}