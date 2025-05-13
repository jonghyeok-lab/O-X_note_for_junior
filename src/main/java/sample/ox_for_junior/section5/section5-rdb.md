#### 실행 계획
- selected_type : DEPENDENT, DERIVED
  - 서브 쿼리나 union 쿼리일 확률이 높다.
- type: index(인덱스 풀 스캔), fulltext(전문 검색), all(테이블 풀 스캔)
- extra: Full scan~, Impossible~, No matching~, Using filesort, Using temporary(temp 파일 사용), Using join buffer(join이 인덱스를 사용할 수 없어서 buffer 사용)

#### MySQL 조언
1. 외래키 사용은 지양
   - 외래키 없어도 조인 가능
   - 외래키 사용 순간 write 성능이 크게 저하
     - 학습한 것처럼 쓰기 작업시, 여러 락이 걸리며 락 경합을 유도함.

2. 쿼리에 논리 로직을 넣지 말자. 한방 쿼리 하지 말자
   - case, if then, 서브쿼리와 같이 쿼리 자체가 프로그램인 경우가 있다.
   - 이러지 말고, 쿼리를 쪼개서 애플리케이션에서 조합하는게 차라리 낫다.
   - DB한테 어려운 일을 하나 주는 것보다 쉽고 빠른 일을 여러번 주는게 낫다.
     - 인덱스 탈 확률이 높으닌깐?

3. 서브쿼리 하지 말자
   - SELECT (SELECT ...) -> 스칼라 서브쿼리
   - FROM (SELECT ...) -> 인라인뷰 서브쿼리
   - WHERE (SELECT ...) -> 중첩 서브쿼리

4. fulltext index
   - 전문 검색용 인덱스 사용하지 말자,
   - 한계가 분명하고 많다. -> 한계가 발생하면 해결할 수 없다.

5. In 쿼리
   - in쿼리에 들어가는 값이 특정 개수 이상이 되는 순간 풀 스캔으로 변한다.
   - DB마다 특정 개수가 달라진다.
   - 대체적으로 100개 이상 넘어가면 쿼리를 쪼개자.

#### 파티셔닝
- 수평, 수직 파티셔닝이 있다.
  - 수평은 샤딩이랑 같은 말이다.