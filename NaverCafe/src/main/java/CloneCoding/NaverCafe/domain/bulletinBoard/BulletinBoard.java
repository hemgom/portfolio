package CloneCoding.NaverCafe.domain.bulletinBoard;

import CloneCoding.NaverCafe.domain.bulletinBoard.dto.RequestCreateGeneralBulletinBoard;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafeMember.enums.CafeMemberPosition;
import jakarta.persistence.*;
import lombok.*;

import static CloneCoding.NaverCafe.domain.bulletinBoard.enums.BasicBulletinBoardData.*;
import static CloneCoding.NaverCafe.domain.cafeMember.enums.CafeMemberPosition.CAFE_MEMBER;

@Entity
@Table(name = "BULLETIN_BOARD")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BulletinBoard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SEQUENCE")
    private int sequence;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "WRITE_AUTH")
    private String writeAuth;

    @Column(name = "READ_AUTH")
    private String readAuth;

    @Column(name = "COMMENT_AUTH")
    private String commentAuth;

    @Column(name = "USE_FAVORITE")
    private boolean useFavorite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAFE_ID")
    private Cafe cafeId;

    public static BulletinBoard createBasicBulletinBoard(Cafe cafe) {
        return BulletinBoard.builder()
                .sequence(1)
                .name(BASIC_NAME.getValue())
                .description(DESCRIPTION.getValue())
                .writeAuth(CAFE_MEMBER.name())
                .readAuth(CAFE_MEMBER.name())
                .commentAuth(CAFE_MEMBER.name())
                .useFavorite(true)
                .cafeId(cafe)
                .build();
    }

    public static BulletinBoard createGeneralBulletinBoard(Cafe cafe, RequestCreateGeneralBulletinBoard request) {
        return BulletinBoard.builder()
                .sequence(request.getSequence())
                .name(request.getName())
                .description(request.getDescription())
                .writeAuth(changeToPosition(request.getWriteAuth()))
                .readAuth(changeToPosition(request.getReadAuth()))
                .commentAuth(changeToPosition(request.getCommentAuth()))
                .useFavorite(request.isUseFavorite())
                .cafeId(cafe)
                .build();
    }

    private static String changeToPosition(String value) {
        CafeMemberPosition position = CafeMemberPosition.findByPosition(value);
        return position.name();
    }

}
