package CloneCoding.NaverCafe.domain.bulletinBoard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BasicBulletinBoardData {

    BASIC_NAME("자유게시판"),
    GENERAL_NAME("새로운 통합게시판"),
    DESCRIPTION(""),
    ;

    private final String value;

    }
