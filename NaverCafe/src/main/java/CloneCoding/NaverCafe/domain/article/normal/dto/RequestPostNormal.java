package CloneCoding.NaverCafe.domain.article.normal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPostNormal {

    @NotNull
    private Long menuId;

    @NotNull
    private String title;

    @NotNull
    private String titleHeader;

    @NotNull
    private String body;

    @NotNull
    private List<String> tags = new ArrayList<>();

    @NotNull
    private boolean notice;

    @NotNull
    private boolean allowComment;

}
