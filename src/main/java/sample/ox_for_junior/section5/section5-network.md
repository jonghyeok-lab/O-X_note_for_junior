#### 네트워크 용어 정리
- VIP
  - virtual IP Address의 약자로 고정되지 않는 클라우드의 IP를 고정시킨다. 즉, 대표 IP.
  - LB역할도 한다.
- GSLB
  - Global Server Load Balancing 의 약자
  - 데이터 센터를 다른 지역에 두고, 각 데이터 센터의 VIP 를 DNS에 등록
  - -> 하지만, DNS는 장애 감지를 할 수 없어서 장애난 데이터 센터에 요청을 계속 보낸다.
  - -> 이를 위해 DNS와 데이터센터 사이에 GSLB를 둔다.
  - GSLB는 DNS 기반의 LB라서 IP가 아닌 도메인을 가진다.
- 흐름
```angular2html
요청 -> DNS -> GSLB -> VIP1 -> IP1, IP2
                   -> VIP2 -> IP3, IP4
# 돈이 많이 깨져서 VIP 없이 사용하는 경우도 존재
요청 -> DNS -> GSLB -> (IP1, IP2), (IP3, IP4)
```
- L4 vs L7
  - L4 로드밸런싱
    - IP/Port 기반
    - ex) GSLB, VIP
  - L7 로드밸런싱
    - URI/Header/
  - 로드밸런싱 구성은 DSR(Direct Server Return, 서버 응답 시 LB거치지 않고 클라이언트에게 즉시 전송)와 Inline(LB를 프록시처럼 사용) 으로 나뉜다.
  

- FQDN(Full qualified domain name)
  - www 같은 서브 도메인도 포함한 풀 도메인
```angular2html
helloworld.com (x)
www.sub.helloworld.com(o)
```

- ACL(Access control list)
  - 네트워크 망에 접근을 허가하는 IP 리스트를 의미한다.
  - 화이트 리스트 방식으로 관리

- SSH인증 과정
  - 개발자 할 일
    - `ssh-keygen -t rsa -f ./new-key.pub`같이 서버에서 비대칭키 한쌍 생성
    - public키, 도메인, 인증 서명 요청의 정보를 들고서 인증 기관(CA)에서 인증서 생성 요청 -> 인증 서명 요청이라 부름(CSR)
    - 인증 기관은 인증 기관의 private키로 암호화한 인증서를 주고, 개발자는 인증서를 다운로드
    - 인증서를 가지고, SSL 설정.
  - SSL 인증 방식
    - 브라우저는 CA의 public키를 내장하고 있음.
    - SSL통신을 위해 서버로 부터 인증서를 받고, 이를 CA의 public키로 복호화해서 인증서 안에 있는 서버의 public key를 가져옴.
    - 임의의 대칭키를 만들고, 서버의 public key로 대칭키를 암호화.
    - 암호화된 값을 서버로 전송, 서버는 이를 private 키로 복호화.
    - 서버-클라이언트는 세션키로 암호화 통신.