package CloneCoding.NaverCafe.domain.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@Getter
@RequiredArgsConstructor
public enum MenuType {

    POPULAR("기본", "인기글"),
    TAG("기본", "카페태그보기"),
    CALENDER("기본", "카페 캘린더"),
    BOOKSHELF("기본", "카페북 책꽂이"),
    KNOWLEDGE("기본", "카페지식활동"),
    INTEGRATE("일반", "통합게시판"),
    SALE("일반", "상품등록게시판"),
    STAFF("일반", "스탭게시판"),
    RANK_UP("일반", "등업게시판"),
    MEMO("일반", "메모게시판"),
    ATTEND("일반", "출석부"),
    CAFE_BOOK("일반", "카페북"),
    ;

    private final String div;
    private final String type;

    public static MenuType findByType(String type) {

        for (MenuType m : values()) {
            if (m.getType().equals(type)) {
                return m;
            }
        }

        throw new RuntimeException(new NoSuchElementException("타입 정보를 찾을 수 없습니다."));

    }

}
