package CloneCoding.NaverCafe.domain.article.normal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import static CloneCoding.NaverCafe.domain.article.normal.enums.BasicData.*;

@Getter
@Builder
@AllArgsConstructor
public class ResponseNormalForm {

    public ResponseNormalForm() {
        this.menu = MENU.getValue();
        this.titleHeader = TITLE_HEADER.getValue();
        this.title = TITLE.getValue();
        this.body = BODY.getValue();
        this.tag = TAG.getValue();
        this.notice = false;
        this.allowComment = true;
    }

    private final String menu;

    private final String titleHeader;

    private final String title;

    private final String body;

    private final String tag;

    private final boolean notice;

    private final boolean allowComment;

}
