package factory


import factoryPattern.idCardFactory.framework.Factory
import factoryPattern.idCardFactory.idcard.IDCardFactory
import org.junit.Before
import org.junit.Test

class IDFactoryTest{

    lateinit var factory:Factory

    @Before
    fun beforeTest(){
        factory = IDCardFactory()
    }
    @Test
    fun testFactory(){
        val card1 = factory.create("James")

        val card2 = factory.create("Tom")

        val card3 = factory.create("PETER")

        card1.use()
        card2.use()
        card3.use()
        factory.showOwners()
    }
}