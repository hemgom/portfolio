package CloneCoding.NaverCafe.domain.cafe.dto;

import CloneCoding.NaverCafe.domain.cafe.HowToJoin;
import lombok.Getter;

import static CloneCoding.NaverCafe.domain.cafe.BasicURL.BASIC_URL;
import static CloneCoding.NaverCafe.domain.cafe.FormBasicData.*;

@Getter
public class ResponseCreateForm {

    public ResponseCreateForm() {
        this.name = PLEASE_INPUT_CAFE_NAME.getDate();
        this.basicUrl = BASIC_URL.getUrl();
        this.addUrl = PLEASE_INPUT_URL.getDate();
        this.icon = DEFAULT_CAFE_ICON.getDate();
        this.howToJoin = HowToJoin.SIGN_UP_NOW.getOption();
        this.useRealName = false;
        this.openMemberList = false;
        this.mainCategory = CHOICE_MAIN_CATEGORY.getDate();
        this.subCategory = CHOICE_SUB_CATEGORY.getDate();
        this.description = PLEASE_INPUT_CAFE_DESCRIPTION.getDate();
        this.keyword = PLEASE_INPUT_CAFE_KEYWORD.getDate();
        this.activityArea = NOT_ACTIVITY_AREA.getDate();
    }

    private final String name;

    private final String basicUrl;
    private final String addUrl;

    private final String icon;

    private final String howToJoin;

    private final boolean useRealName;

    private final boolean openMemberList;

    private final String mainCategory;
    private final String subCategory;

    private final String description;

    private final String keyword;

    private final String activityArea;

}
