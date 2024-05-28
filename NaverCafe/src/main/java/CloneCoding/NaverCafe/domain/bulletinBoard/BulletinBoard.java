package CloneCoding.NaverCafe.domain.bulletinBoard;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import jakarta.persistence.*;
import lombok.*;

import static CloneCoding.NaverCafe.domain.bulletinBoard.enums.BasicBulletinBoardData.BASIC_DESCRIPTION;
import static CloneCoding.NaverCafe.domain.bulletinBoard.enums.BasicBulletinBoardData.BASIC_NAME;
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
                .description(BASIC_DESCRIPTION.getValue())
                .writeAuth(CAFE_MEMBER.getPosition())
                .readAuth(CAFE_MEMBER.getPosition())
                .commentAuth(CAFE_MEMBER.getPosition())
                .useFavorite(true)
                .cafeId(cafe)
                .build();
    }

}
