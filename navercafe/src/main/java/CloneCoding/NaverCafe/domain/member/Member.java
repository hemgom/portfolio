package CloneCoding.NaverCafe.domain.member;

import CloneCoding.NaverCafe.domain.member.dto.RequestUpdateMember;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static CloneCoding.NaverCafe.security.LoginStatus.STATUS_LOGOUT;

@Entity
@Table(name = "MEMBER")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ACCOUNT_ID", unique = true)
    private String accountId;

    @Column(name = "ACCOUNT_PASSWORD")
    private String accountPassword;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "PHONE_NUMBER", unique = true)
    private String phoneNumber;

    @Column(name = "NICKNAME", unique = true)
    private String nickname;

    @Column(name = "STATUS")
    @Builder.Default
    private String status = STATUS_LOGOUT.getStatus();

    public void setLoginStatus(String status) {
        this.status = status;
    }

    public void updateInfo(RequestUpdateMember request) {

        if (request.getEmail() != null) {
            this.email = request.getEmail();
        }

        if (request.getPhoneNumber() != null) {
            this.phoneNumber = request.getPhoneNumber();
        }

        if (request.getNickname() != null) {
            this.nickname = request.getNickname();
        }

    }

    public void updateAccountPassword(String changeAccountPassword) {
        this.accountPassword = changeAccountPassword;
    }

}
