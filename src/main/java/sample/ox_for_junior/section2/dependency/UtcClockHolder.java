package sample.ox_for_junior.section2.dependency;

// 배포용
public class UtcClockHolder implements ClockHolder {

    @Override
    public long getMillis() {
        return 0;
    }
}
