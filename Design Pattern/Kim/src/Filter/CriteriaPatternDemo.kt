package Filter

fun main(args: Array<String>) {
    val persons = mutableListOf<Person>()

    persons.add(Person("Robert", "Male", "Single"))
    persons.add(Person("John", "Male", "Married"))
    persons.add(Person("Laura", "Female", "Married"))
    persons.add(Person("Diana", "Female", "Single"))
    persons.add(Person("Mike", "Male", "Single"))
    persons.add(Person("Bobby", "Male", "Single"))

    val male = CriteriaMale()
    val female = CriteriaFemale()
    val single = CriteriaSingle()
    val singleMale = AndCriteria(single, male)
    val singleOrFemale = OrCriteria(single, female)

    println("Males: ")
    printPersons(male.meetCriteria(persons))

    println("\nFemales: ")
    printPersons(female.meetCriteria(persons))

    println("\nSingle Males: ")
    printPersons(singleMale.meetCriteria(persons))

    println("\nSingle Or Females: ")
    printPersons(singleOrFemale.meetCriteria(persons))
}

fun printPersons(persons: MutableList<Person>) {

    for (person in persons) {
        println("Person : [ Name : " + person.name + ", Gender : " + person.gender + ", Marital Status : " + person.maritalStatus + " ]")
    }
}
