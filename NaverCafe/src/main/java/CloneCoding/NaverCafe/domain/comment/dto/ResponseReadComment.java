package CloneCoding.NaverCafe.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseReadComment {

    private String profileImage;

    private String nickname;

    private String accountId;

    private String targetAccountId;

    private String targetNickname;

    private String body;

    private LocalDateTime updateAt;

}
