package CloneCoding.NaverCafe.domain.article.normal;

import CloneCoding.NaverCafe.domain.article.normal.dto.RequestPostNormal;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.favorite.Favorite;
import CloneCoding.NaverCafe.domain.tag.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "normalId", fetch = FetchType.LAZY)
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "normalId", fetch = FetchType.LAZY)
    private List<Favorite> favorites = new ArrayList<>();

    public static Normal create(RequestPostNormal request, CafeMember cafeMember) {

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

    public void update(RequestPostNormal request) {
        this.menuId = request.getMenuId();
        this.titleHeader = request.getTitleHeader();
        this.title = request.getTitle();
        this.body = request.getBody();
        this.notice = request.isNotice();
        this.allowComment = request.isAllowComment();
    }

    public void addViewCount() {
        this.viewCount++;
    }

    public void addFavoriteCount() {
        this.favoriteCount++;
    }

    public void subFavoriteCount() {
        this.favoriteCount--;
    }

    public void addCommentCount() { this.commentCount++; }

    public void subCommentCount() { this.commentCount--; }

}
