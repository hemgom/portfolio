package CloneCoding.NaverCafe.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static CloneCoding.NaverCafe.domain.comment.enums.BasicData.DEFAULT_BODY;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseReplyForm {

    private String nickname;

    private String targetNickname;

    @Builder.Default
    private String body = DEFAULT_BODY.getValue();

}
