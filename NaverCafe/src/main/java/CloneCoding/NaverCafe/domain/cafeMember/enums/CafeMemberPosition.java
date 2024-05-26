package CloneCoding.NaverCafe.domain.cafeMember.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CafeMemberPosition {

    MANAGER(0, "매니저", "카페 매니저", "카페 매니저"),
    SUB_MANAGER(1, "스탭", "부 매니저", "부 매니저"),
    WELCOME_STAFF(2, "스탭", "카페 스탭", "신입 맞이 스탭"),
    DESIGN_STAFF(2, "스탭", "카페 스탭", "디자인 스탭"),
    EVENT_STAFF(2, "스탭", "카페 스탭", "이벤트 스탭"),
    ENTIRE_BULLETIN_BOARD_STAFF(2, "스탭", "카페 스탭", "전체 게시판 스탭"),
    EACH_BULLETIN_BOARD_STAFF(2, "스탭", "카페 스탭", "개별 게시판 스탭"),
    MEMBERSHIP_STAFF(2, "스탭", "카페 스탭", "멤버등급 스탭"),
    GROUP_BUYING_STAFF(2, "스탭", "카페 스탭", "공동구매 스탭"),
    CAFE_MEMBER(8, "회원", "카페 멤버", "일반 멤버")
    ;

    private final int priority;
    private final String grade;
    private final String position;
    private final String detailPosition;

}
