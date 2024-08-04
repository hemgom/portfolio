package CloneCoding.NaverCafe.domain.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ResponseReadComments {

    public ResponseReadComments(List<ResponseReadComment> comments) {
        this.comments = comments;
    }

    private List<ResponseReadComment> comments = new ArrayList<>();

}
