package strategypattern.example2

class Apple() {

    var color:String =""
    var weight:Int = 0

    constructor(color:String,weight:Int):this(){
        this.color = color
        this.weight = weight
    }

    override fun toString(): String {
        return "Apple(color='$color', weight=$weight)"
    }

}