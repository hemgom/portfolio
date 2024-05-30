package CloneCoding.NaverCafe.domain.article.normal;

import CloneCoding.NaverCafe.domain.article.normal.dto.RequestWriteNormal;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "NORMAL_ARTICLE")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Normal {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MENU_ID")
    private Long menuId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "TITLE_HEADER")
    private String titleHeader;

    @Column(name = "BODY")
    private String body;

    @Column(name = "NOTICE")
    private boolean notice;

    @Column(name = "ALLOW_COMMENT")
    private boolean allowComment;

    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "CREATE_AT")
    private LocalDateTime createAt;

    @Column(name = "VIEW_COUNT")
    @Builder.Default
    private int viewCount = 0;

    @Column(name = "COMMENT_COUNT")
    @Builder.Default
    private int commentCount = 0;

    @Column(name = "FAVORITE_COUNT")
    @Builder.Default
    private int favoriteCount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAFE_ID")
    private Cafe cafeId;

    public static Normal create(RequestWriteNormal request, CafeMember cafeMember) {

        LocalDateTime now = LocalDateTime.now();

        return Normal.builder()
                .menuId(request.getMenuId())
                .title(request.getTitle())
                .titleHeader(request.getTitleHeader())
                .body(request.getBody())
                .notice(request.isNotice())
                .allowComment(request.isAllowComment())
                .accountId(cafeMember.getAccountId())
                .nickname(cafeMember.getNickname())
                .createAt(now)
                .cafeId(cafeMember.getCafeId())
                .build();
    }

}
