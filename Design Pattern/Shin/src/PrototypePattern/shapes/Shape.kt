package PrototypePattern.shapes

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

/**
 * Created by Shin on 2017/10/20.
 */
abstract class Shape():Cloneable {
    var id:String? = null
    abstract var type:String
    public override fun clone(): Any {
        return super.clone() as Shape

    }

    abstract fun draw()
}

class Rectangle():Shape() {
    override var type:String = "Rectangle"

    override fun draw() {
        println("Inside Rectangle::draw() method.")
    }

}

class Square():Shape() {
    override var type:String = "Square"

    override fun draw() {
        println("Inside Square::draw() method.")
    }

}

class Circle():Shape() {
    override var type:String = "Circle"

    override fun draw() {
        println("Inside Circle::draw() method.")
    }

}