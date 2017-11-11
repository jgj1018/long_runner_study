package decotest

abstract class Display {

    public abstract fun getColumns() : Int //가로 문자수를 얻는다
    public abstract fun getRows() : Int    //세로 행수를 얻는다.
    public abstract fun getRowText(row : Int) : String?

    public final fun show(){
        for (i in 0..getRows()-1){
            println(getRowText(i))
        }
    }
}