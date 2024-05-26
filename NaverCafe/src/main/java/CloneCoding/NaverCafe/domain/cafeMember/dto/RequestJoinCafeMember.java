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
public class RequestJoinCafeMember {

    @NotNull
    private String profileImage;

    @NotNull
    @Size(min = 2, max = 20, message = "별명은 2 ~ 20자로 제한됩니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]+", message = "별명은 영소문자, 영대문자, 숫자만 입력 가능합니다.")
    private String nickname;

    @NotNull
    private boolean genderAgeOpen;

}
