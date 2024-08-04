package CloneCoding.NaverCafe.domain.menu.normal.integrate.dto;

import lombok.Getter;

import static CloneCoding.NaverCafe.domain.menu.normal.integrate.enums.BasicData.DESCRIPTION;
import static CloneCoding.NaverCafe.domain.menu.normal.integrate.enums.BasicData.GENERAL_NAME;
import static CloneCoding.NaverCafe.domain.cafeMember.enums.CafeMemberPosition.CAFE_MEMBER;

@Getter
public class ResponseCreateForm {

    public ResponseCreateForm() {
        this.name = GENERAL_NAME.getValue();
        this.description = DESCRIPTION.getValue();
        this.writeAuth = CAFE_MEMBER.getPosition();
        this.readAuth = CAFE_MEMBER.getPosition();
        this.commentAuth = CAFE_MEMBER.getPosition();
        this.useFavorite = true;
    }

    private final String name;

    private final String description;

    private final String writeAuth;

    private final String readAuth;

    private final String commentAuth;

    private final boolean useFavorite;

}
