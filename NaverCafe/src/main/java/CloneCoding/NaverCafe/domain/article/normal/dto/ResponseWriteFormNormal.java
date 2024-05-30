package CloneCoding.NaverCafe.domain.article.normal.dto;

import lombok.Getter;

import static CloneCoding.NaverCafe.domain.article.normal.enums.BasicData.*;

@Getter
public class ResponseWriteFormNormal {

    public ResponseWriteFormNormal() {
        this.menu = MENU.getValue();
        this.titleHeader = TITLE_HEADER.getValue();
        this.title = TITLE.getValue();
        this.body = BODY.getValue();
        this.tag = TAG.getValue();
    }

    private final String menu;

    private final String titleHeader;

    private final String title;

    private final String body;

    private final String tag;

}
