package internal

class TestObject(){

    private lateinit var name:String
    private  var age:Int = 0
    constructor( name:String,  age:Int) : this() {
        this.name = name
        this.age = age
    }
}