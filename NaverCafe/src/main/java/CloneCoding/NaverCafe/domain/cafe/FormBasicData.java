package CloneCoding.NaverCafe.domain.cafe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FormBasicData {

    PLEASE_INPUT_CAFE_NAME("카페 이름을 입력해주세요."),
    PLEASE_INPUT_URL("카페 주소를 입력해주세요."),
    DEFAULT_CAFE_ICON("default image route"),
    CHOICE_MAIN_CATEGORY("대분류 선택"),
    CHOICE_SUB_CATEGORY("소분류 선택"),
    PLEASE_INPUT_CAFE_DESCRIPTION("카페 설명을 입력해주세요."),
    PLEASE_INPUT_CAFE_KEYWORD("검색어를 입력해주세요."),
    NOT_ACTIVITY_AREA("활동 지역은 따로 없습니다."),
    ;

    private final String date;

}
