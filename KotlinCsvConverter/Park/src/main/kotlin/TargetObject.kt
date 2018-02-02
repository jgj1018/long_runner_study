import java.time.LocalDate

 class TargetObject( private var date:LocalDate?, private var title:String?, private var income:Int?, private var outcome:Int?, private var comment:String? ) {

    override fun toString(): String {

        return "val date : ${date.toString()}, val title : ${title.toString()}, " +
                "val income : ${income}, val outcome : ${outcome}, val comment : ${comment}"
    }
}