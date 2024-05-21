package CloneCoding.NaverCafe.domain.cafe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BasicURL {

    BASIC_URL("https://cafe.naver.com/")
    ;

    private final String url;

}
