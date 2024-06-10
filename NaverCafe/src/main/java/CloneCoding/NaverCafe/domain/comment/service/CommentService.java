package CloneCoding.NaverCafe.domain.comment.service;

import CloneCoding.NaverCafe.domain.comment.dto.RequestWriteComment;
import CloneCoding.NaverCafe.domain.comment.dto.ResponseReadComments;
import CloneCoding.NaverCafe.domain.comment.dto.ResponseReplyForm;
import CloneCoding.NaverCafe.domain.comment.dto.ResponseWriteForm;

public interface CommentService {

    ResponseWriteForm createForm(String url, String token);

    String createComment(String url, Long id, RequestWriteComment request, String token);

    ResponseReplyForm createForm(String url, Long commentId, String token);

    String createReply(String url, Long articleId, Long commentId, RequestWriteComment request, String token);

    ResponseReadComments createCommentList(String cafeUrl, Long articleId, String token);

    String updateComment(String url, Long commentId, RequestWriteComment request, String token);

    String delComment(String cafeUrl, Long normalId, Long commentId, String token);

}
