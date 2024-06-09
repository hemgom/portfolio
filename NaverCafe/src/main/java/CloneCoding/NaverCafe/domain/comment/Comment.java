package CloneCoding.NaverCafe.domain.comment;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.comment.dto.RequestWriteComment;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENT")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MENU_ID")
    private Long menuId;

    @Column(name = "PROFILE_IMAGE")
    private String profileImage;

    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "BODY")
    private String body;

    @Column(name = "CREATE_AT")
    private LocalDateTime createAt;

    @Column(name = "UPDATE_AT")
    private LocalDateTime updateAt;

    @Column(name = "COMMENT_GROUP")
    private int commentGroup;

    @Column(name = "TARGET_ACCOUNT_ID")
    @Builder.Default
    private String targetAccountId = "";

    @Column(name = "TARGET_NICKNAME")
    @Builder.Default
    private String targetNickname = "";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAFE_ID")
    private Cafe cafeId;

    public static Comment create(CafeMember cafeMember, Long menuId, int commentGroup,
                                 RequestWriteComment request) {
        return Comment.builder()
                .menuId(menuId)
                .profileImage(cafeMember.getProfileImage())
                .accountId(cafeMember.getAccountId())
                .nickname(cafeMember.getNickname())
                .body(request.getBody())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .commentGroup(commentGroup)
                .cafeId(cafeMember.getCafeId())
                .build();
    }

    public static Comment createReply(CafeMember cafeMember, Long menuId, int commentGroup,
                                 String targetAccountId, String targetNickname, RequestWriteComment request) {
        return Comment.builder()
                .menuId(menuId)
                .profileImage(cafeMember.getProfileImage())
                .accountId(cafeMember.getAccountId())
                .nickname(cafeMember.getNickname())
                .body(request.getBody())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .commentGroup(commentGroup)
                .targetAccountId(targetAccountId)
                .targetNickname(targetNickname)
                .cafeId(cafeMember.getCafeId())
                .build();
    }

}
