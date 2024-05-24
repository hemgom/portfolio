package CloneCoding.NaverCafe.domain.cafeMember;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FormBasicData {

    DEFAULT_PROFILE_IMAGE("default image route"),
    ;

    private final String data;

}
