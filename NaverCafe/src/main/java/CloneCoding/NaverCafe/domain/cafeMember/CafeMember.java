package CloneCoding.NaverCafe.domain.cafeMember;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestJoinCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestUpdateCafeMember;
import CloneCoding.NaverCafe.domain.member.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static CloneCoding.NaverCafe.domain.cafeMember.enums.CafeMemberPosition.*;

@Entity
@Table(name = "CAFE_MEMBER", uniqueConstraints = {
        @UniqueConstraint(
                name = "ACCOUNT_ID_UNIQUE",
                columnNames = {"CAFE_ID", "ACCOUNT_ID"}
        ),
        @UniqueConstraint(
                name = "USERNAME_UNIQUE",
                columnNames = {"CAFE_ID", "NICKNAME"}
        )})
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CafeMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "PROFILE_IMAGE")
    @Builder.Default
    private String profileImage = "default_image";

    @Column(name = "DESCRIPTION")
    @Builder.Default
    private String description = "자기소개를 입력해주세요";

    @Column(name = "GENDER_AGE_OPEN")
    @Builder.Default
    private boolean genderAgeOpen = true;

    @Column(name = "MY_BLOG_OPEN")
    @Builder.Default
    private boolean myBlogOpen = false;

    @Column(name = "POPULAR_MEMBER_PUSH")
    @Builder.Default
    private boolean popularMemberPush = true;

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

    public static CafeMember createCafeManager(String accountId, String nickname,
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

    public static CafeMember createCafeMember(RequestJoinCafeMember request,
                                              Cafe cafe, Member member) {

        String nickname = checkNickname(request.getNickname(), member.getNickname());

        return CafeMember.builder()
                .accountId(member.getAccountId())
                .nickname(nickname)
                .profileImage(request.getProfileImage())
                .genderAgeOpen(request.isGenderAgeOpen())
                .gender(member.getGender())
                .birthday(member.getBirthday())
                .cafeId(cafe)
                .build();
    }

    private static String checkNickname(String request, String basic) {

        if (request.isEmpty()) return basic;

        return request;

    }

    public void update(RequestUpdateCafeMember request) {

        this.profileImage = request.getProfileImage();

        if (!request.getNickname().isEmpty()) {
            this.nickname = request.getNickname();
        }

        this.description = request.getDescription();
        this.genderAgeOpen = request.isOpenSetting();
        this.myBlogOpen = request.isMyBlogOpen();
        this.popularMemberPush = request.isPopularMemberPush();

    }

}
