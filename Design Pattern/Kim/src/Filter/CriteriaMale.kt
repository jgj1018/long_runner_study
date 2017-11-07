package Filter

class CriteriaMale : Criteria {

    override fun meetCriteria(persons: MutableList<Person>): MutableList<Person> {
        val malePersons = mutableListOf<Person>()

        for (person in persons) {
            if (person.gender.equals("MALE", ignoreCase = true)) {
                malePersons.add(person)
            }
        }
        return malePersons
    }
}