package filter.concreteLevel

import filter.aPILevel.Criteria

class CriteriaFeMale : Criteria {
    override fun meetCriteria(persons: List<Person>): List<Person> {
        val femalePersons:MutableList<Person> = ArrayList()

        for( person in persons){
            if(person.getGender().equals("FEMALE",true)){
                femalePersons.add(person)
            }
        }
        return femalePersons
    }
}