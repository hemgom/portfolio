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

    @Column(name = "REPLY_MAIN")
    @Builder.Default
    private Long replyMain = 0L;

    @Column(name = "REPLY_TARGET")
    @Builder.Default
    private Long replyTarget = 0L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAFE_ID")
    private Cafe cafeId;

    public static Comment create(CafeMember cafeMember, Long menuId, RequestWriteComment request) {
        return Comment.builder()
                .menuId(menuId)
                .profileImage(cafeMember.getProfileImage())
                .accountId(cafeMember.getAccountId())
                .nickname(cafeMember.getNickname())
                .body(request.getBody())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .cafeId(cafeMember.getCafeId())
                .build();
    }

    public void setMainId(Long commentId) {
        this.replyMain = commentId;
    }

    public void setTargetId(Long commentId) {
        this.replyTarget = commentId;
    }

}
