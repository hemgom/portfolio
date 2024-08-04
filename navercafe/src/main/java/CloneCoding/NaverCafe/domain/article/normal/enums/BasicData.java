package CloneCoding.NaverCafe.domain.article.normal.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BasicData {

    CURRENT_ACTIVITY("카페 글쓰기"),
    MENU("게시판을 선택해 주세요."),
    TITLE_HEADER("말머리 선택"),
    TITLE("제목을 입력해 주세요."),
    BODY("내용을 입력하세요."),
    TAG("# 태그를 입력해 주세요. (최대 10개)"),
    DEFAULT_ARTICLE_URL("https://cafe.naver.com"),
    LEAVE_COMMENT("댓글을 남겨보세요."),
    ;

    private final String value;

}
