package CloneCoding.NaverCafe.domain.member.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestJoinMember {

    @NotNull
    @Size(min = 5, max = 20,
            message = "계정 아이디는 5 ~ 20자로 제한됩니다.")
    @Pattern(regexp = "^[a-z0-9_-]+",
            message = "계정 아이디는 영소문자, 영대문자, 숫자만 사용 가능합니다.")
    private String accountId;

    @NotNull
    @Size(min = 8, max = 16,
            message = "계정 비밀번호는 8 ~ 16자로 제한됩니다.")
    @Pattern(regexp = "^[a-zA-Z0-9~!@#$%]+",
            message = "계정 비밀번호는 영소문자, 영대문자, 숫자, 특수문자(~, !, @, #, $, %)만 사용 가능합니다.")
    private String accountPassword;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_]+@[a-zA-Z]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)?",
            message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotNull
    @Size(min = 2, max = 18, message = "이름은 2 ~ 18자로 제한됩니다.")
    @Pattern(regexp = "^[a-zA-Z]+", message = "이름은 영소문자, 영대문자만 사용 가능합니다.")
    private String username;

    @NotNull
    @Min(value = 1924, message = "태어난 연도의 입력 가능 범위는 1924 ~ 2024 입니다.")
    @Max(value = 2024, message = "태어난 연도의 입력 가능 범위는 1924 ~ 2024 입니다.")
    private int year;

    @NotNull
    @Min(value = 1, message = "태어난 달의 입력 가능 범위는 1 ~ 12 입니다.")
    @Max(value = 12, message = "태어난 달의 입력 가능 범위는 1 ~ 12 입니다.")
    private int month;

    @NotNull
    @Min(value = 1, message = "태어난 날의 입력 가능 범위는 1 ~ 31 입니다.")
    @Max(value = 31, message = "태어난 날의 입력 가능 범위는 1 ~ 31 입니다.")
    private int day;

    @NotNull
    @Size(min = 11, max = 11, message = "휴대전화번호는 11자 입니다.")
    @Pattern(regexp = "^[0-9]+", message = "휴대전화번호는 숫자만 입력 가능합니다.")
    private String phoneNumber;

    @NotNull
    @Size(min = 2, max = 20, message = "별명은 2 ~ 20자로 제한됩니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]+", message = "별명은 영소문자, 영대문자, 숫자만 입력 가능합니다.")
    private String nickname;

}