##■인터페이스와 abstract 클래스의 차이 

함수를 Overriding을 하기 위해서 java에서는 abstract 또는 interface를 사용합니다.
abstract은 extends을 이용하여 상속을 구현하고, interface은 implements을 이용하여 상속을 구현합니다.

* 차이점
  * <b>인터페이스는 변수를 초기화X <->추상클래스 변수초기화 O</b> 
   <br>( _인터페이스의 경우 프로퍼티는 가질 수 있지만 상태를 가질 수 없다_ )<br>
  ->따라서 추상 클래스는 프로퍼티와 함께 작동하는 구현 부분을 캡슐화 할 수 있으므로 파생 클래스에서 재정의 할 수 없다.<br>
  (즉, 인터페이스는 속성만 정의할 수 있어서 안정적인 방식으로 인터페이스에 일부 상태를 저장하는 논리를 정의할 수 없음)
  * <b>인터페이스 기본구현부 O <-> 추상클래스의 추상메소드는 구현부 X</b>
  
        interface interfacetest{
  
          var test1 : String?
          val test2 : String?="11"//<--error
          
          fun test(){
              val test3 : String?="11"
              test1 ="22"
           }
        }
  
          abstract class abstracttest {
              
              val test : String? ="22"
              
              abstract fun testabs()
          }
  
  * <b>인터페이스는 다중상속O <-> 추상클래스 다중상속X</b>
  
  
  
##■추상클래스와 인터페이스 언제 사용하나?

**추상클래스**<br> 
- 여러개의 가까운 클래스들 (is-a 관계가 형성될) 사이에 동일한 코드를 공유해서 사용하고 싶을때.
<b>육군(부모클래스)-운전병(자식클래스),통신병(자식클래스),cp병(자식클래스),조리병(자식클래스)</b><br>
- 추상클래스를 상속한 클래스들이 많은 공통 메소드들과 필드와 public 보다 다양한 접근 제어자에 의해 사용하고 싶을때.
- non-static 과 non-final 필드를 선언하고 싶을때.  결과적으로 객체들의 상태를 메소드에서 접근하고 수정 할 수 있게 되겠지.

**인터페이스**<br>
- 크게 상관없는(is-a 정도는 아닌 has-a 정도인) 클래스들이 너의 인터페이스를 구현( java8 부터는 구현된 것을 사용도 포함)해야 할 필요가 있을때. 예를들어 Comparable and Cloneable
<br><b> 당번(불침번, 청소당번, 쓰래기통당번-인터페이스) - 운전병(구현),통신병(구현),cp병(구현),조리병(구현)</b></br>
- 특정 데이터타입의 행위를 특별하게 구현하길 원할때 그러나 누가 그것의 행위를 구현 했는지에 대한 관심은 없을때 
- 다중 구현상속의 이점을 누려야 할때 



##■인터페이스 구현부 지원의 이점

- 정적 메서드
<br>기술적으로 Java에서 인터페이스에 정적 메서드를 추가하지 못할 이유는 없었다. 
<br>정적 메서드는 어차피 인스턴스와 관계가 없기 때문이다. 
<br>다만 정적 메서드도 구현된 메서드라는 점에서 인터페이스의 추상성을 해친다는 것이 문제였다. 
<br>Java 8에서는 그러한 제약이 없어졌고, 인터페이스에 정적 메서드를 추가할 수 있게 되었다.
<br>(사실 이전에도 인터페이스에 정적 필드는 정의할 수 있었기 때문에 정적 메서드가 Java 8에 와서야 추가된 것은 조금 의아하다.) 
기존의 제약을 깨고 정적 메서드를 추가한 것은 개발 편의성을 높이려는 시도로 보인다. 
<br>Java 8 이전의 표준 라이브러리에서는 인터페이스와 관련된 정적 메서드들을 동반 클래스(companion class)에서 제공했다.
<br>Ex) Collection 인터페이스와 Collections 동반 클래스

        // 인터페이스와 동반 클래스의 예.
        Collection<String> empty = Collections.emptyList();



- 기본 메서드(default method)
<br>Java 8에서는 인터페이스에 기본 구현을 정의할 수 있게되었다. 기본 구현이 제공되는 메서드는 구현 클래스에서 구현하지 않아도 컴파일이 가능하다. 
기본 메서드는 기존의 인터페이스에 메서드를 추가해야하는 경우에 아주 유용하다. 인터페이스가 변경되는 일이 없도록 프로그램을 잘 작성하는게 좋겠지만 변경이 불가피한 상황이 생길 수도 있다. 인터페이스에 메서드를 추가하면 해당 인터페이스를 구현하는 모든 클래스에서 추가된 메서드를 구현해야하기 때문에 문제가 생긴다. 구현 클래스가 9개라면 인터페이스까지 10개의 파일을 수정해야 한다. 하지만 추가되는 메서드의 구현이 대부분 동일하다면 인터페이스에 기본적인 메서드 구현을 정의하고 유별난 클래스만 수정해주면 된다. 
연료 유형을 포함하는 Car 인터페이스를 예로 들어보자.

        public interface Car {
            String fuelType();
        }
연료 유형에 따른 구현 클래스들도 있다.
        
        public class DieselCar implements Car {
            @Override
            public String fuelType() {
                return "DIESEL";
            }
        }
        
        public class GasolineCar implements Car {
            @Override
            public String fuelType() {
                return "GASOLINE";
            }
        }
자동 주행 차량에 발빠르게 대응하기 위해서 Car 인터페이스에 자동 주행 차량 여부를 확인할 수 있는 메서드가 추가되어야한다고 생각해보자. 
<br>Car는 아래와 같이 변경되어야 한다.

        public interface Car {
            String fuelType();
            boolean autodrive();
        }


이 경우에 autodrive() 메서드는 기본 구현을 제공하지 않으므로 DieselCar, GasolineCar에서 구현해줘야 한다. 하지만 기존 차량들은 자율 주행이 안될 것이기 때문에 아래와 같이 기본 구현을 제공할 수 있다.

        public interface Car {
            String fuelType();
            default boolean autodrive() {
                return false;
            }
        }

autodrive()는 FutureCar와 같은 유별난 클래스에서만 따로 구현해주면 된다.

        public class FutureCar implements Car {
            @Override
            public String fuelType() {
                return "SOLAR";
            }
            @Override
            public boolean autodrive() {
                return true;
            }
        }
        
인터페이스의 기본 메서드는 클래스의 계층을 좀 더 단순하게 만들어준다는 장점도 있다. Java 2부터 있어왔던 AbstractCollection은 Collection 구현 클래스들의 공통 기능을 제공한다. Java 8 이전에는 구현 클래스들의 공통 기능들을 묶기 위해 인터페이스와 구현 클래스 사이에 추상 클래스를 정의하는 것이 일반적이었다. 
<br>하지만 Java 8에 와서는 더 이상 추상 클래스를 추가할 필요 없이 기본 메서드를 정의할 수 있게 되었다. 이런 변화로 인터페이스와 추상 클래스의 경계가 모호해졌다는 느낌이 들지만 여전히 인스턴스 변수의 유무 차이는 존재한다.



