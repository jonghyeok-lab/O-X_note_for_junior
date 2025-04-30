package sample.ox_for_junior.section2.dependency;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// 개발용
@Component
@Profile("dev")
public class SystemClockHolder implements ClockHolder {

    @Override
    public long getMillis() {
        return System.currentTimeMillis();
    }
}
