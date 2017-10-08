package singleton

import org.junit.Test

class SingletonTest{

    @Test
    fun singletonTest(){
        var single = SingleObject
        single.showMessage()

        var single2 = SingleObject
        single2.showMessage()
    }
}