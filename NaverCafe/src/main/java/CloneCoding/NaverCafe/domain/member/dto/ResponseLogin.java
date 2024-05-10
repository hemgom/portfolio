package CloneCoding.NaverCafe.domain.member.dto;

import CloneCoding.NaverCafe.message.SystemMessage;
import lombok.Getter;

@Getter
public class ResponseLogin {

    public ResponseLogin() {
    }

    public ResponseLogin(String token) {
        this.token = token;
    }

    private final String message = SystemMessage.LOGIN_COMPLETE.getMessage();

    private String token;

}
