package decotest

class SideBorder() :Border() {

    var borderCahr : Char = '\u0000'

    public constructor(display: Display, char: Char) : this(){
        super.display = display
        this.borderCahr = char
    }

    override fun getColumns(): Int = display!!.getColumns() +2 //문자수는 내용물 양쪽에 장식 문자수 더한 것

    override fun getRows(): Int = display!!.getRows()//행수는 내용물의 행수와 동일

    override fun getRowText(row: Int): String? =
            borderCahr.toString() + display!!.getRowText(row)+ borderCahr.toString()//지정된 행의 내용은 내용물의 지정된 행의 양쪽 장식문자가 추가된 것
}