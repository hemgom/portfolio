package CloneCoding.NaverCafe.domain.cafeMember.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUpdateForm {

    private String profileImage;

    private String nickname;

    private String description;

    private boolean genderAgeOpen;

    private boolean myBlogOpen;

    private boolean popularMemberPush;

}
