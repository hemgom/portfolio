package CloneCoding.NaverCafe.domain.comment.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BasicData {

    DEFAULT_BODY("댓글을 남겨 보세요."),
    ;

    private final String value;

}
