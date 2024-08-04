package CloneCoding.NaverCafe.domain.cafe.dto;

import jakarta.validation.Valid;
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

    @NotNull @Valid
    private CafeInfo cafeInfo;

    private List<String> keywords = new ArrayList<>();

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CafeInfo {

        @NotNull
        @Size(min = 1, max = 60,
                message = "카페 이름은 1 ~ 60자로 제한됩니다.")
        @Pattern(regexp = "\\s*([0-9\\S]+)\\s*",
                message = "카페 이름은 공백, 탭을 제외한 문자가 적어도 하나 이상 존재해야 합니다.")
        private String name;

        @NotNull
        @Size(min = 1, max = 20,
                message = "카페 주소는 1 ~ 20자로 제한됩니다.")
        @Pattern(regexp = "^[a-zA-Z0-9]+",
                message = "카페 주소는 영소문자, 영대문자, 숫자만 사용 가능합니다.")
        private String url;

        @NotNull
        private String icon;

        @NotNull
        private String howToJoin;

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

        @NotNull
        private String activityArea;

    }

}
