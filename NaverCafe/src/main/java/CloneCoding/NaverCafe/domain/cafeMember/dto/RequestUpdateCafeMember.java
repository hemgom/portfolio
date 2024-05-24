package CloneCoding.NaverCafe.domain.cafeMember.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateCafeMember {

    @NotNull
    private String url;

    @NotNull
    private UpdateCafeMemberInfo updateCafeMemberInfo;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateCafeMemberInfo {

        private String profileImage = "default_image";

        private String nickname = "";

        private String description = "";

        private boolean openSetting = true;

        private boolean myBlogOpen = false;

        private boolean popularMemberPush = true;

    }

}
