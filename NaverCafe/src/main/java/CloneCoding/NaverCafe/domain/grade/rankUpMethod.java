package CloneCoding.NaverCafe.domain.grade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum rankUpMethod {

    NONE("설정안함"),
    AUTO("자동등업"),
    USE_BULLETIN_BOARD("등업게시판")
    ;

    private final String message;

}
