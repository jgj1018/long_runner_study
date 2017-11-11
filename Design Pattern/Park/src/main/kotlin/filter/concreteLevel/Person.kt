package filter.concreteLevel

class Person(private val name:String, private val gender:String, private val maritalStatus:String) {

    fun getName():String{
        return this.name
    }
    fun getGender():String{
        return this.gender
    }
    fun getMaritalStatus():String{
        return this.maritalStatus
    }

}