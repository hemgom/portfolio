package CloneCoding.NaverCafe.domain.cafe.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@Getter
@RequiredArgsConstructor
public enum ActivityArea {

    NONE("없음"),
    SEOUL("서울특별시"),
    GYEONGGI("경기도"),
    INCHEON("인천광역시"),
    BUSAN("부산광역시"),
    DAEJEON("대전광역시"),
    DAEGU("대구광역시"),
    ULSAN("울산광역시"),
    SEJONG("세종특별자치시"),
    GWANGJU("광주광역시"),
    GANGWON("강원특별자치도"),
    CHUNGCHEONG_NORTH("충청북도"),
    CHUNGCHEONG_SOUTH("충청남도"),
    GYEONGSANG_NORTH("경상북도"),
    GYEONGSANG_SOUTH("경상남도"),
    JEOLLA_NORTH("전북특별자치도"),
    JEOLLA_SOUTH("전라남도"),
    JEJU("제주특별자치도")
    ;

    private final String name;

    public static ActivityArea findByName(String name) {

        for (ActivityArea area : values()) {
            if (area.getName().equals(name)) {
                return area;
            }
        }

        throw new RuntimeException(new NoSuchElementException("지역 정보를 찾을 수 없습니다."));

    }

}
