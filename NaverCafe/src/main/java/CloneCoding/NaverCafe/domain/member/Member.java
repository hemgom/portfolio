package CloneCoding.NaverCafe.domain.member;

import CloneCoding.NaverCafe.message.Login;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static CloneCoding.NaverCafe.message.Login.*;

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

    @Column(name = "PHONE_NUMBER", unique = true)
    private String phoneNumber;

    @Column(name = "NICKNAME", unique = true)
    private String nickname;

    @Column(name = "STATUS")
    @Builder.Default
    private String status = STATUS_LOGOUT.getStatus();

    @Column(name = "TOKEN")
    @Builder.Default
    private String token = EMPTY_TOKEN.getStatus();

    public void setLoginStatus(String status) {
        this.status = status;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
