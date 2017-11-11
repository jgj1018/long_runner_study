package decotest

public abstract class Border() : Display(){
//장식을 나타내는 추상 클래스. 장식을 표시하지만 문자열 표시를 실행하는 display의 하위 클래스로 정의
//즉, 장식은 중심내용물과 동일한 메소드를 가진다. = 인터페이스(API)적으로 장식과 내용물을 동일시 할 수 있다는 의미
    var display : Display? = null

    public constructor(dispaly : Display):this(){
        this.display =display
    }
}