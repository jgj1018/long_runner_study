package singletonpattern

public class SingleObject private constructor(){

    companion object Singleton{
        fun getInstance()= SingleObject()

    }

    public fun showMassage() :Unit{
        println("Hello World!")
    }

}
