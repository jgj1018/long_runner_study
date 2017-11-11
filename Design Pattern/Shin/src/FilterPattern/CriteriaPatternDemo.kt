package FilterPattern

import FilterPattern.criteria.*

fun main(args: Array<String>) {
    val persons = mutableListOf<Person>()

    // 읽기 전용 (Not Immutable Only Read-Only)
    // personsReadOnly.add() 불가
    val personsReadOnly:List<Person> = persons

    persons.add(Person("Robert", "Male", "Single"))
    persons.add(Person("John", "Male", "Married"))
    persons.add(Person("Laura", "Female", "Married"))
    persons.add(Person("Diana", "Female", "Single"))
    persons.add(Person("Mike", "Male", "Single"))
    persons.add(Person("Bobby", "Male", "Single"))

    val male: Criteria = CriteriaMale()
    val female: Criteria = CriteriaFemale()
    val single: Criteria = CriteriaSingle()
    val singleMale: Criteria = AndCriteria(single, male)
    val singleOrFemale: Criteria = OrCriteria(single, female)

    println("Males: ")
    printPersons(male.meetCriteria(personsReadOnly))
    println()
    println("Females: ")
    printPersons(female.meetCriteria(personsReadOnly))
    println()
    println("Single males: ")
    printPersons(singleMale.meetCriteria(personsReadOnly))
    println()
    println("Single or Females: ")
    printPersons(singleOrFemale.meetCriteria(personsReadOnly))

    println()
    println()
    println()

    // String의 확장 함수로 isMale()을 만듬
    //
    fun String.isMale():Boolean = this.equals("MALE", true)

    println("Males: ")

    // 컬렉션의 filter로 gender가 male인지 확인
    personsReadOnly.filter { it.gender.isMale() }.forEach{ println(it.toString()) }
    println()
    println("Females: ")
    personsReadOnly.filter {
        it.gender.equals("FEMALE", true)
    }.forEach {
        println(it.toString())
    }
    println()
    println("Single males: ")
    personsReadOnly.filter {
        it.maritalStatus.equals("SINGLE", true) && it.gender.equals("MALE", true)
    }.forEach {
        println(it.toString())
    }
    println()
    println("Single or Females: ")
    personsReadOnly.filter {
        it.maritalStatus.equals("SINGLE", true) || it.gender.equals("FEMALE", true)
    }.forEach {
        println(it.toString())
    }

    println()
    println()
    println()
    personsReadOnly.filter { it.gender.equals("MALE", true) }.map { it.toString() }.forEach { println(it) }
}

fun printPersons(persons:List<Person>) {
    persons.forEach {
        println(it.toString())
    }
}