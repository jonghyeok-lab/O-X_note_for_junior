package sample.ox_for_junior.section2;

import io.micrometer.common.util.StringUtils;

public class UserInfo {

    private final long id;
    private final String username;
    private final String email;

    public UserInfo(long id, String username, String email) {
        assert id > 0;
        assert StringUtils.isNotEmpty(username);
//        assert EmailValidator.isValid(email);
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
