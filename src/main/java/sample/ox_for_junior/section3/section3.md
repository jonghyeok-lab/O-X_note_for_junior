#### 트랜잭션 스크립트 패턴
- DDD적용 -> 4개의 레이어
  - controller -> application service(응용 계층) -> domain model(도메인 계층) -> repository(인프라스트럭쳐 계층)
  - 응용계층은 최대한 얇게 유지, 작업을 조정하고 아래에 위치한 계층에 도메인 객체의 협력자에게 작업을 위임한다.
  - 로직자체가 목적인 객체를 두고 도메인 서비스라 부른다. ex) PriceCalculator

#### 추상화
- 시스템 외부 연동(DB, WebClient | RestTemplate) 은 가능하면 모두 추상화.
![img_2.png](img_2.png)
- 좋은 설계인지 확인하는 방법은 테스트 하기 쉬운 코드인가를 확인하는 방법이다.
- 장점 
  - 외부와 애플리케이션간에 결합도가 느슨해짐
  - 별도의 FakeRepository 사용 가능 -> 별도의 DB 띄울 필요 없음 -> Elasticsearch 같은 서비스도 테스트 가능.

#### 기타
- 외래키는 다쪽에 생긴다. 외래키로 참조된 객체를(Member/Team에서 Team)을 연관관계의 주인, mappedBy
- n+1해결 방법
  1. EntityGraph
  2. Fetch join
  3. Persistence를 추상화한 설계로도 해결 가능.

- CQRS패턴 적용 -> Reader / Writer 쓴다.
  - 같은 테이블을 참조하더라도 Reader용 Entity 따로, Writer용 Entity 따로 만든다.
```angular2html
Repository | Object       | Type
UserReader | UserReadOnly | VO
UserWriter | UserEditable | Editable object
```