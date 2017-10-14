package abstractfactorypattern.`interface`

public interface Color{
    fun fill(){

        var classnamelist = this.javaClass.toString().split(".")
        var idx = classnamelist.lastIndex

        if(classnamelist[idx] is String){
            println("Inside [${classnamelist[idx]}]::fill() method")
        }
    }
}