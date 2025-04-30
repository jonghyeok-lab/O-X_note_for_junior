package sample.ox_for_junior.section2.dependency;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.ox_for_junior.section2.UserInfo;

@RequiredArgsConstructor
@Service
public class UserService {

    // 컴파일 의존성과 런타임 의존성이 다르다.
    private final ClockHolder clockHolder;

    public void login(User user) {
        user.login(clockHolder);
    }
}
