package CloneCoding.NaverCafe.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestJoinMember {

    private String accountId;

    private String accountPassword;

    private String email;

    private String username;

    private int year;

    private int month;

    private int day;

    private String phoneNumber;

    private String nickname;

}