### 섹션1,2
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

#### TDA(Tell don`t ask) 원칙
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