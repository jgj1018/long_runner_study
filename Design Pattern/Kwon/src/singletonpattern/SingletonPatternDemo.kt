package singletonpattern

public class SingletonPatternDemo{
}

fun main(args: Array<String>) {
   val singletonobject = SingleObject.Singleton.getInstance()
    singletonobject.showMassage()
}