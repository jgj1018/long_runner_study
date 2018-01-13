Mediator Pattern
===

 * https://www.tutorialspoint.com/design_pattern/mediator_pattern.htm

# 정의
 * "상호작용하는 오브젝트들의 집합을 캡슐화하는 오브젝트"
 * 오브젝트간의 통신을 mediator로 캡슐화해서, 오브젝트간의 통신을 항상 mediator가 경유하도록 한다. 이를 통해 오브젝트끼리의 의존 관계를 줄인다.
 * 오브젝트끼리 서로 참조하지 않도록, 중개역이 될 오브젝트를 통해서 제어하는 방법을 제공한다.

# 역할
 1. Mediator(중개자)
    * Collegue의 상담을 모두 받아서, 그것을 바탕으로 판단하고, Colleague에게 지시를 내린다. 각 Colleague의 상담 창구 인터페이스를 정의한다.
    * consultation(상담) 관헌하에 있는 Colleague를 격납하기 위한 인터페이스를 제공한다.
 2. ConcreteMediator
    * Mediator 인터페이스를 구현한다. 실제로 Colleague를 보존하고, 그것들로부터 상담을 받고, 판단을 내리고, 그것들에게 지시를 내린다.
 3. Colleague(동료)
    *  다른 Colleague를 제어하고 싶을때는, Mediator에게 상담한다. Mediator의 지시를 받을 창구 인터페이스를 정의한다. 자신이 상담할 Mediator를 격납할 메소드를 정의한다.
 4. ConcreteColleague
    * Colleague 인터페이스를 구현한다.
 5. Client(이용자)
    * Mediator 패턴을 이용한 클래스를 사용해서 처리를 행한다.
 
 * http://www.ie.u-ryukyu.ac.jp/~e085739/java.it.18.html
 

실행결과
---
```
Sun Jan 07 20:31:58 JST 2018 [Robert] : Hi! John!
Sun Jan 07 20:31:58 JST 2018 [John] : Hello! Robert!
```

