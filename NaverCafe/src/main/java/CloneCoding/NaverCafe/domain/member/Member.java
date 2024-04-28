package CloneCoding.NaverCafe.domain.member;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

}
