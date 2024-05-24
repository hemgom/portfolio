package CloneCoding.NaverCafe.domain.cafe;

import CloneCoding.NaverCafe.domain.cafe.dto.RequestCreateCafe;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.keyword.Keyword;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static CloneCoding.NaverCafe.domain.cafe.BasicURL.BASIC_URL;

@Entity
@Table(name = "CAFE")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Cafe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "URL", unique = true)
    private String url;

    @Column(name = "ICON")
    private String icon;

    @Column(name = "PRIVACY_JOIN_SETTING")
    private String howToJoin;

    @Column(name = "USE_REAL_NAME")
    private boolean useRealName;

    @Column(name = "OPEN_MEMBER_LIST")
    private boolean openMemberList;

    @Column(name = "MAIN_CATEGORY")
    private String mainCategory;

    @Column(name = "SUB_CATEGORY")
    private String subCategory;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ACTIVITY_AREA")
    private String activityArea;

    @OneToMany(mappedBy = "cafeId", fetch = FetchType.LAZY)
    private List<Keyword> keywords = new ArrayList<>();

    @OneToMany(mappedBy = "cafeId", fetch = FetchType.LAZY)
    private List<CafeMember> members = new ArrayList<>();

    public static Cafe createCafe(RequestCreateCafe.CafeInfo cafeInfo) {

        HowToJoin htj = HowToJoin.findByOption(cafeInfo.getHowToJoin());

        return Cafe.builder()
                .name(cafeInfo.getName())
                .url(BASIC_URL.getUrl() + cafeInfo.getUrl())
                .icon(cafeInfo.getIcon())
                .howToJoin(htj.name())
                .useRealName(cafeInfo.isUseRealName())
                .openMemberList(cafeInfo.isOpenMemberList())
                .mainCategory(cafeInfo.getMainCategory())
                .subCategory(cafeInfo.getSubCategory())
                .description(cafeInfo.getDescription())
                .activityArea(cafeInfo.getActivityArea())
                .build();
    }

}
