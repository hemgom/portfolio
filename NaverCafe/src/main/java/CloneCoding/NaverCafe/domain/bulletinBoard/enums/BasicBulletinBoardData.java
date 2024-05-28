package CloneCoding.NaverCafe.domain.bulletinBoard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BasicBulletinBoardData {

    BASIC_NAME("자유게시판"),
    BASIC_DESCRIPTION(""),
    ;

    private final String value;

    }
