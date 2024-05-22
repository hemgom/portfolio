package CloneCoding.NaverCafe.domain.cafeMember.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestJoinCafeMember {

    @NotNull
    private String url;

    @NotNull
    private CafeMemberInfo cafeMemberInfo;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CafeMemberInfo {

        private String profileImage = "default_image";

        private String nickname = "";

        private boolean openSetting = true;

    }

}
