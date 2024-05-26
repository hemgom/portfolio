package CloneCoding.NaverCafe.domain.cafeMember.dto;

import lombok.Getter;

import static CloneCoding.NaverCafe.domain.cafeMember.enums.FormBasicData.DEFAULT_PROFILE_IMAGE;

@Getter
public class ResponseJoinForm {

    public ResponseJoinForm(String nickname) {
        this.profileImage = DEFAULT_PROFILE_IMAGE.getData();
        this.nickname = nickname;
        this.genderAgeOpen = true;
    }

    private final String profileImage;

    private final String nickname;

    private final boolean genderAgeOpen;

}
