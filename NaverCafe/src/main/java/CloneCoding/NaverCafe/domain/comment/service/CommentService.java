package CloneCoding.NaverCafe.domain.comment.service;

import CloneCoding.NaverCafe.domain.comment.dto.RequestWriteComment;
import CloneCoding.NaverCafe.domain.comment.dto.ResponseWriteForm;

public interface CommentService {

    ResponseWriteForm createForm(String url, Long id, String token);

    String createComment(String url, Long id, RequestWriteComment request, String token);

}
