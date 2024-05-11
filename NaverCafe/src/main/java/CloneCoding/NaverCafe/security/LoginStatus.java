package CloneCoding.NaverCafe.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LoginStatus {

    STATUS_LOGIN("login"),
    STATUS_LOGOUT("logout")
    ;

    private final String status;

}
