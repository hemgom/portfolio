package CloneCoding.NaverCafe.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SystemMessage {

    JOIN_COMPLETE_NAVER("정상적으로 회원가입을 완료했습니다!" +
            System.lineSeparator() +
            "로그인 페이지로 이동해 로그인 해주세요."),
    LOGIN_COMPLETE("정상적으로 로그인이 완료되었습니다!"),
    LOGOUT_COMPLETE("정상적으로 로그아웃이 완료되었습니다!")
    ;

    private final String message;

}