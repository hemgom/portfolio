package CloneCoding.NaverCafe.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Login {

    STATUS_LOGIN("login"),
    STATUS_LOGOUT("logout")
    ;

    private final String status;

}
