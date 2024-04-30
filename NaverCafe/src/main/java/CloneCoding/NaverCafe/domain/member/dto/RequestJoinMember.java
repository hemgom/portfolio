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
    @Size(min = 5, max = 20)
    @Pattern(regexp = "^[a-z0-9_-]+")
    private String accountId;

    @NotNull
    @Size(min = 8, max = 16)
    @Pattern(regexp = "^[a-zA-Z0-9~!@#$%]+", message = "비밀번호 정규식 오류")
    private String accountPassword;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_]+@[a-zA-Z]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)?")
    private String email;

    @NotNull
    @Size(min = 2, max = 18)
    @Pattern(regexp = "^[a-zA-Z]+")
    private String username;

    @NotNull
    @Min(value = 1924) @Max(value = 2024)
    private int year;

    @NotNull
    @Min(value = 1) @Max(value = 12)
    private int month;

    @NotNull
    @Min(value = 1) @Max(value = 31)
    private int day;

    @NotNull
    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[0-9]+")
    private String phoneNumber;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9]+")
    private String nickname;

}