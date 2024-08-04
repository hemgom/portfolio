package CloneCoding.NaverCafe.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMemberInfo {

    private String accountId;
    private String email;
    private String username;
    private LocalDate birthday;
    private String phoneNumber;
    private String nickname;

}
