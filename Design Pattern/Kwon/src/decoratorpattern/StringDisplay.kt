package decotest

public class StringDisplay() : Display(){

    var string :String = ""

    public constructor(string : String) : this() {
        this.string = string
    }

    override fun getColumns(): Int = string.length  //가로 문자수를 얻는다

    override fun getRows(): Int = 1  //StringDisplay 클래스에서 표시하는 것은 1행이므로 1 부여

    override fun getRowText(row: Int): String? {
        if( row == 0) {
            return string
        }else{
            return null
        }
    }
}