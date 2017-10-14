package factorypattern.`interface`

public interface Shape{
    fun draw(){
        //var classfoundflag = false
        var classnamelist = this.javaClass.toString().split(".")
        var idx = classnamelist.lastIndex

        if(classnamelist[idx] is String){
            println("Inside [${classnamelist[idx]}]::draw() method")
        }
    }
}