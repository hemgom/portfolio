package CloneCoding.NaverCafe.domain.cafe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@Getter
@RequiredArgsConstructor
public enum HowToJoin {

    SIGN_UP_NOW("바로 가입"),
    SIGN_UP_APPROVED("가입 승인"),
    ACCEPT_INVITATION("초대 승인")
    ;

    private final String option;

    public static HowToJoin findByOption(String option) {

        for (HowToJoin setting : values()) {
            if (setting.getOption().equals(option)) {
                return setting;
            }
        }

        throw new RuntimeException(new NoSuchElementException("설정 정보를 찾을 수 없습니다."));

    }

}
