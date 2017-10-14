package abstractfactorypattern

import abstractfactorypattern.factory.AbstractFactory
import abstractfactorypattern.factory.ColorFactory
import abstractfactorypattern.factory.ShapeFactory

public class FactoryProducer{

    companion object {
        fun getFactory(choice : String?): AbstractFactory?=
                when (choice){
                    "SHAPE" -> ShapeFactory()
                    "COLOR" -> ColorFactory()
                    else    -> null
                }
    }
}