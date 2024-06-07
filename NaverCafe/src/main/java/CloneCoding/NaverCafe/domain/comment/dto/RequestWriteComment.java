package CloneCoding.NaverCafe.domain.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RequestWriteComment {

    @NotNull
    private String body;

}
