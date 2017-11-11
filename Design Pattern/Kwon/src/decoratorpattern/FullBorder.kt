package decotest

//FullBorder클래스
//SideBorder클래스는 장식문자 지정가능했지만 장식할 문자가 고정되 있음
class FullBorder() :Border() {

    public constructor(display: Display) : this(){
        super.display = display
    }

    override fun getColumns(): Int = display!!.getColumns()+2

    override fun getRows(): Int = display!!.getRows() +2

    override fun getRowText(row: Int): String? {
        if(row == 0){
            //장식의 상단
            return "+${makeLine('-',display!!.getColumns())}+"
        } else if (row == display!!.getRows() +1) {
            //장식의 하단
            return "+${makeLine('-',display!!.getColumns())}+"
        } else {
            return "|${display!!.getRowText(row-1)}|"
        }

        return ""
    }

    private fun makeLine(char: Char, count: Int): String{
        //문자 ch를 count개 연속시킨 문자열을 만든다.

        var buf : StringBuffer = StringBuffer()

        for(i in 0..count) {
            buf.append(char)
        }
        return buf.toString()
    }
}