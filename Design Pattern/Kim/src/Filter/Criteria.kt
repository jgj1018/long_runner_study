package Filter

interface Criteria {
    fun meetCriteria(persons: MutableList<Person>): MutableList<Person>
}