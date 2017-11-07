package Filter

class CriteriaFemale : Criteria {

    override fun meetCriteria(persons: MutableList<Person>): MutableList<Person> {
        val femalePersons = mutableListOf<Person>()

        for (person in persons) {
            if (person.gender.equals("FEMALE", ignoreCase = true)) {
                femalePersons.add(person)
            }
        }
        return femalePersons
    }
}