package abstractfactorypattern.`interface`

public interface Shape{
    fun draw(){

        var classnamelist = this.javaClass.toString().split(".")
        var idx = classnamelist.lastIndex

        if(classnamelist[idx] is String){
            println("Inside [${classnamelist[idx]}]::draw() method")
        }
    }
}