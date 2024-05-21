package CloneCoding.NaverCafe.domain.cafeMember;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static CloneCoding.NaverCafe.domain.cafeMember.CafeMemberPosition.*;

@Entity
@Table(name = "CAFE_MEMBER")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CafeMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ACCOUNT_ID", unique = true)
    private String accountId;

    @Column(name = "NICKNAME", unique = true)
    private String nickname;

    @Column(name = "PROFILE_IMAGE")
    @Builder.Default
    private String profileImage = "default_image";

    @Column(name = "DESCRIPTION")
    @Builder.Default
    private String description = "자기소개를 입력해주세요";

    @Column(name = "OPEN_SETTING")
    @Builder.Default
    private boolean openSetting = true;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Column(name = "POSITION")
    @Builder.Default
    private String position = CAFE_MEMBER.name();

    @Column(name = "GRADE")
    @Builder.Default
    private String grade = "-";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAFE_ID")
    private Cafe cafeId;

    public static CafeMember addCafeManager(String accountId, String nickname,
                                             String gender, LocalDate birthday,
                                             Cafe cafe) {
        return CafeMember.builder()
                .accountId(accountId)
                .nickname(nickname)
                .gender(gender)
                .birthday(birthday)
                .position(MANAGER.name())
                .grade(MANAGER.getGrade())
                .cafeId(cafe)
                .build();
    }

}
