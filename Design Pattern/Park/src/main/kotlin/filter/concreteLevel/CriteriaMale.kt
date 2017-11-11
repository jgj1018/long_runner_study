package filter.concreteLevel

import filter.aPILevel.Criteria

class CriteriaMale:Criteria {
    override fun meetCriteria(persons: List<Person>): List<Person> {
        val malePersons:MutableList<Person> = ArrayList()

        for( person in persons){
            if(person.getGender().equals("MALE",true)){
                malePersons.add(person)
            }
        }
        return malePersons
    }
}