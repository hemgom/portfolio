package CloneCoding.NaverCafe.domain.comment.repository;

import CloneCoding.NaverCafe.domain.comment.Comment;

import java.util.List;

public interface QueryCommentRepository {

    List<Comment> findByArticleId(Long articleId);

}
