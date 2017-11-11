package FilterPattern.criteria

import FilterPattern.Person

class CriteriaSingle:Criteria {
    override fun meetCriteria(persons: List<Person>): List<Person> = persons.filter { it.maritalStatus.equals("SINGLE", true) }.toMutableList()
}