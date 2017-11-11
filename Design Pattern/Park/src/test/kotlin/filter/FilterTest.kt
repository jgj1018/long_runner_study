package filter

import filter.concreteLevel.*
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FilterTest {
    val persons:MutableList<Person> = ArrayList()
    @Before
    fun setPersons(){
        persons.add(Person("Robert", "Male", "Single"))
        persons.add(Person("John", "Male", "Married"))
        persons.add(Person("Laura", "FeMale", "Married"))
        persons.add(Person("Diana", "FeMale", "Single"))
        persons.add(Person("Mike", "Male", "Single"))
        persons.add(Person("Bobby", "Male", "Single"))
    }
    @Test
    fun testFilter(){
        val male = CriteriaMale()
        val female = CriteriaFeMale()
        val single = CriteriaSingle()
        val singleMale = AndCriteria(single,male)
        val singleOrMale=OrCriteria(single,male)

        for(person in male.meetCriteria(persons)){
            assertEquals("Male", person.getGender())
        }
        for(person in female.meetCriteria(persons)){
            assertEquals("FeMale", person.getGender())
        }
        for(person in singleMale.meetCriteria(persons)){
            assertEquals("Male", person.getGender())
            assertEquals("Single", person.getMaritalStatus())

        }
        for(person in male.meetCriteria(persons)){
            assertTrue(person.getGender() == "Male" || person.getMaritalStatus() == "Single")
        }

        assertEquals(4, male.meetCriteria(persons).size)
        assertEquals(2, female.meetCriteria(persons).size)
        assertEquals(3, singleMale.meetCriteria(persons).size)
        assertEquals(5, singleOrMale.meetCriteria(persons).size)

    }
}