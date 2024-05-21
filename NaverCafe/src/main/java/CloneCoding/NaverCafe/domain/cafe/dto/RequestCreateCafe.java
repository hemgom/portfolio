package CloneCoding.NaverCafe.domain.cafe.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateCafe {

    private CafeInfo cafeInfo;
    private List<String> keywords = new ArrayList<>();

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CafeInfo {

        @NotEmpty
        @Size(min = 1, max = 60,
                message = "카페 이름은 1 ~ 60자로 제한됩니다.")
        private String name;

        @NotNull
        @Size(min = 1, max = 20,
                message = "카페 주소는 1 ~ 20자로 제한됩니다.")
        @Pattern(regexp = "^[a-zA-Z0-9]+",
                message = "카페 주소는 영소문자, 영대문자, 숫자만 사용 가능합니다.")
        private String url;

        private String icon = "basic_img";

        @NotNull
        private String privacyJoinSetting;

        @NotNull
        private boolean useRealName;

        @NotNull
        private boolean openMemberList;

        @NotNull
        private String mainCategory;

        @NotNull
        private String subCategory;

        @NotNull
        private String description;

        private String activityArea = "없음";

    }

}
