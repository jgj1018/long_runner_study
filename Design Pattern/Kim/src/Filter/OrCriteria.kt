package Filter

class OrCriteria(private val criteria: Criteria, private val otherCriteria: Criteria) : Criteria {

    override fun meetCriteria(persons: MutableList<Person>): MutableList<Person> {
        val firstCriteriaItems = criteria.meetCriteria(persons)
        val otherCriteriaItems = otherCriteria.meetCriteria(persons)

        for (person in otherCriteriaItems) {
            if (!firstCriteriaItems.contains(person)) {
                firstCriteriaItems.add(person)
            }
        }
        return firstCriteriaItems
    }
}