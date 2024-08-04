package CloneCoding.NaverCafe.domain.member.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateMember {

    @Pattern(regexp = "^[a-zA-Z0-9_]+@[a-zA-Z]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)?",
            message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @Size(min = 11, max = 11, message = "휴대전화번호는 11자 입니다.")
    @Pattern(regexp = "^[0-9]+", message = "휴대전화번호는 숫자만 입력 가능합니다.")
    private String phoneNumber;

    @Size(min = 2, max = 20, message = "별명은 2 ~ 20자로 제한됩니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]+", message = "별명은 영소문자, 영대문자, 숫자만 입력 가능합니다.")
    private String nickname;

}
