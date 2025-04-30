package sample.ox_for_junior.section2.dependency;

public class User {

    private long lastTimeLogin;

    // 변하는 값 의존성 주입
    public void login(ClockHolder clockHolder) {
        lastTimeLogin = clockHolder.getMillis();
    }
}
