package CloneCoding.NaverCafe.domain.menu.normal.integrate;

import CloneCoding.NaverCafe.domain.menu.MenuType;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.RequestCreateIntegrate;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafeMember.enums.CafeMemberPosition;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.RequestUpdateIntegrate;
import jakarta.persistence.*;
import lombok.*;

import static CloneCoding.NaverCafe.domain.menu.MenuType.*;
import static CloneCoding.NaverCafe.domain.menu.normal.integrate.enums.BasicData.*;
import static CloneCoding.NaverCafe.domain.cafeMember.enums.CafeMemberPosition.CAFE_MEMBER;

@Entity
@Table(name = "INTEGRATE")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Integrate {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SEQUENCE")
    private int sequence;

    @Column(name = "TYPE")
    private String type;

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

    public static Integrate createDefaultIntegrate(Cafe cafe) {
        return Integrate.builder()
                .sequence(1)
                .type(INTEGRATE.name())
                .name(BASIC_NAME.getValue())
                .description(DESCRIPTION.getValue())
                .writeAuth(CAFE_MEMBER.name())
                .readAuth(CAFE_MEMBER.name())
                .commentAuth(CAFE_MEMBER.name())
                .useFavorite(true)
                .cafeId(cafe)
                .build();
    }

    public static Integrate createIntegrate(Cafe cafe, RequestCreateIntegrate request) {
        return Integrate.builder()
                .sequence(request.getSequence())
                .type(changeToType(request.getType()))
                .name(request.getName())
                .description(request.getDescription())
                .writeAuth(changeToPosition(request.getWriteAuth()))
                .readAuth(changeToPosition(request.getReadAuth()))
                .commentAuth(changeToPosition(request.getCommentAuth()))
                .useFavorite(request.isUseFavorite())
                .cafeId(cafe)
                .build();
    }

    public void updateIntegrate(RequestUpdateIntegrate request) {
        this.sequence = request.getSequence();
        this.name = request.getName();
        this.description = request.getDescription();
        this.writeAuth = changeToPosition(request.getWriteAuth());
        this.readAuth = changeToPosition(request.getReadAuth());
        this.commentAuth = changeToPosition(request.getCommentAuth());
        this.useFavorite = request.isUseFavorite();
    }

    private static String changeToPosition(String value) {
        CafeMemberPosition position = CafeMemberPosition.findByPosition(value);
        return position.name();
    }

    private static String changeToType(String value) {
        MenuType type = MenuType.findByType(value);
        return type.name();
    }

}
