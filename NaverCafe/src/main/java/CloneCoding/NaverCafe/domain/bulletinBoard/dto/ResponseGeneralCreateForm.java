package CloneCoding.NaverCafe.domain.bulletinBoard.dto;

import lombok.Getter;

import static CloneCoding.NaverCafe.domain.bulletinBoard.enums.BasicBulletinBoardData.DESCRIPTION;
import static CloneCoding.NaverCafe.domain.bulletinBoard.enums.BasicBulletinBoardData.GENERAL_NAME;
import static CloneCoding.NaverCafe.domain.cafeMember.enums.CafeMemberPosition.CAFE_MEMBER;

@Getter
public class ResponseGeneralCreateForm {

    public ResponseGeneralCreateForm() {
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
