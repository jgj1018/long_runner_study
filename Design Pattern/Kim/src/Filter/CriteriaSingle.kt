package Filter

class CriteriaSingle : Criteria {

    override fun meetCriteria(persons: MutableList<Person>): MutableList<Person> {
        val singlePersons = mutableListOf<Person>()

        for (person in persons) {
            if (person.maritalStatus.equals("SINGLE", ignoreCase = true)) {
                singlePersons.add(person)
            }
        }
        return singlePersons
    }
}