Kotlin Coffee Shop
===

``` 
 (0) customer check menu([required list] name, price, ingredient)
 [에스프레소 카페라떼 아메리카노 카푸치노]
 (1) customer Order a cup of coffee. [one cup per one person]
 (2) hand over money.
 (3) Order list updated.
 (4) make a cup of coffee.
 (5) hand over the cup of coffee.
 
 * 손님과의 상호작용 처리(커맨드 입력)는 일단 넣지말고 숍 부분 더 넣기
 
 [필수 사항]
 1, 재료 없는 사람은 재료 넣기
 2, 메뉴는 더 추가. 커피 이외의 것
 3, 오더리스트 처리 (복수 주문 처리 - 커피 이외의 것 주문 가능하게)
 
 [제한 사항]
 1, 한 손님은 하나만 주문하는 건 그대로
 2, 숍은 하나인 것 그대로
 3, 필수사항과 선택사항 외의 것은 추가하지 말 것.
 4, 선택사항보다 필수사항을 우선시 할 것.
 
 [선택사항]
 1, 스태프 넣고 싶음 넣을 것.
 2, 재고처리 넣고 싶음 넣을 것.
```

이번 목표:  객체지향 생활체조에 최대한 맞춰서 하기

### 객체지향 생활 체조
```
규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
규칙 2: else 예약어를 쓰지 않는다.
규칙 3: 모든 원시값과 문자열을 포장한다.
규칙 4: 한 줄에 점을 하나만 찍는다.
규칙 5: 줄여쓰지 않는다(축약 금지).
규칙 6: 모든 엔티티를 작게 유지한다.
규칙 7: 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
규칙 8: 일급 콜렉션을 쓴다.
규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.
```



### 반성점  
메뉴 구성이 난잡해졌음
나중에 패턴을 써서 고쳐봐야지

손님이 가게에 들어오는 부분이 부족함
-> 손님이 가게에 들어온다 -> 스태프가 손님이 들어오는걸 알아챈다 -> 인사한다
--> 옵저버 패턴으로 할 수 있을 것 같다

※실행결과
```
Welcome to the Cafe
OurMenu is ...
Espresso
CaffeLatte
Cappuchino
Americano
(End Of Menu)
** Customer says "Espresso(menuName=Espresso, price=1.0), please" **
Price is $1.0
** Customer says "here is 1.0" **
Thank you
Now Making Espresso...
Here is Espresso
** Customer says "Thank you!" **
Your Welcome
```