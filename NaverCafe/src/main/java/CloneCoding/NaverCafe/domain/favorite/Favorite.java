package CloneCoding.NaverCafe.domain.favorite;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "FAVORITE")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Favorite {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PROFILE_IMAGE")
    private String profileImage;

    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "ACTIVE_AT")
    private LocalDateTime activeAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NORMAL_ID")
    private Normal normalId;

    public static Favorite create(CafeMember cafeMember, Normal normal) {
        return Favorite.builder()
                .profileImage(cafeMember.getProfileImage())
                .accountId(cafeMember.getAccountId())
                .nickname(cafeMember.getNickname())
                .activeAt(LocalDateTime.now())
                .normalId(normal)
                .build();
    }

}
