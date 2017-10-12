package abstractfactorypattern.factory

import abstractfactorypattern.`interface`.Color
import abstractfactorypattern.`interface`.Shape

public abstract class AbstractFactory{
    abstract fun getColor(color : String?): Color?
    abstract fun getShape(shape : String?): Shape?
}