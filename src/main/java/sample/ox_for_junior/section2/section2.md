### 컨벤션 교정
#### 순차 지향 vs 절차 지향
1. 순자 지향 프로그래밍 - Sequential oriented programming
    - 어셈블리어
2. 절차 지향 프로그래밍 - Procedure oriented programming
    - C언어
* 컴퓨터 공학에서 Procedure 는 함수, 서브루틴과 같은 말로 불린다.
* 즉, 절차 지향 프로그래밍은 함수 지향 프로그래밍이라 불린다.
* 그래서, 어셈블리어에는 함수가 없다.
****
-> 결론 : 단어 자체에 집중 해보자

#### get vs find
- get : return type 이 T 인 경우, 값이 없으면 throw
- find : return type 이 Optional<T> 인 경우

**#### TDA(Tell don`t ask) 원칙**
```
TO-BE
public void doSomething(User user){
    user.setStatus(INACTIVE);
    user.setLastLoginTime(...);
}

AS IS
public void doSomething(User user) {
    user.inactive();
    user.login(Clock.systemUTC());
}
```
#### 관습
- Map클래스 남발 금지: -> 일급 클래스로 만들기
- range 는 [start, end), inclusive/exclusive

### 객체 지향적 코드(1): 객체의 종류, 행동
#### 값 객체
- VO는 값이 만들어질 때, 값이 유효한지 체크하자.
- 새로운 VO를 만드는 값 객체의 public 메서드는 전치사로 시작할 수 있다,(withNewPassword())

#### PO(Persistence Object)
- Entity와 DB Entity는 다르다.
- JPA의 Entity는 흔히 말하는 DB Entity에 해당, 즉, PO에 해당.

#### JPA의 연관관계
```angular2html
개발자분들이 자꾸 어떻게하면 Spring, Jpa, ORM을 잘 다룰 수 있는지 이런 고민만 더 많이 하게 되는 것 같습니다.
그런데 실제로는 도메인이 훨씬 중요하고, 도메인을 잘 설계한 다음 Jpa를 나중에 갖다 붙이는 방식으로 개발이 되어야 합니다.
양방향 연관 관계는 순환 참조를 써도 된다는 의미가 아니라, "도메인 설계를 하다가 어쩔 수 없이 나오는 순환 참조 문제는 이거라도 써서 해결하세요." 라는 의미로 나온겁니다

도메인 위주의 생각을 먼저 해야 합니다. Jpa랑 도메인이랑 분리해서 생각하는게 먼저고, 순환 참조 없이도 도메인을 만들 수 있는게 먼저이며, 그 다음 Jpa를 갖다 붙이는 겁니다.
```
#### 리스코프 치환 원칙
- 하위 자료형이 상위 자료형의 모든 동작을 완전히 대체 가능해야 한다.
```angular2html
class Rectangle // 사각형
class Square extends Rectangle // 정사각형

Rectangle square = new Square(5);
square.setHeight(10); !!--> Rectangle의 setHeight 사용 시, Square의 특성인 모든 변이 같다라는게 깨진다.
```
#### 의존성 주입과 책임
- 생성자 의존성 주입이 7개 이상 넘어간다면
- 파라미터 의존성 주입이 4개 이상 넘어간다면
- 클래스 분리하라는 신호

#### 변하는 값을 추상화시켜라
- 런타임 의존성과 컴파일 타임 의존성을 다르게 하는 것 -> DIP 활용
- 코드 section2/dependency 참고하기

#### 기타
- 책 추천 : 리팩토링 2판 보다는 WORKIMG EFFECTIVELY WITH LEGACY CODE