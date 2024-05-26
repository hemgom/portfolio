package CloneCoding.NaverCafe.domain.cafeMember.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FormBasicData {

    DEFAULT_PROFILE_IMAGE("default image route"),
    PLEASE_INPUT_DESCRIPTION("자기소개를 입력해주세요."),
    ;

    private final String data;

}
