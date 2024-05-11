package CloneCoding.NaverCafe.domain.member.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RequestUpdateAccountPassword {

    @NotNull
    private String nowAccountPassword;

    @NotNull
    @Size(min = 8, max = 16,
            message = "계정 비밀번호는 8 ~ 16자로 제한됩니다.")
    @Pattern(regexp = "^[a-zA-Z0-9~!@#$%]+",
            message = "계정 비밀번호는 영소문자, 영대문자, 숫자, 특수문자(~, !, @, #, $, %)만 사용 가능합니다.")
    private String changeAccountPassword;

    @NotNull
    private String checkChangeAccountPassword;

}
