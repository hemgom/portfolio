package CloneCoding.NaverCafe.domain.article.normal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseReadNormal {

    private Long menuId;

    private String menuName;

    private String title;

    private String profileImage;

    private String accountId;

    private String nickname;

    private String position;

    private LocalDateTime createAt;

    private int viewCount;

    private int commentCount;

    private String articleUrl;

    private String body;

    private int favoriteCount;

    private String commentNickname;

    private String defaultComment;

    private List<String> tags;

}
