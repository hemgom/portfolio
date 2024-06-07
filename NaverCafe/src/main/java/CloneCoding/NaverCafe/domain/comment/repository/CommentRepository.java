package CloneCoding.NaverCafe.domain.comment.repository;

import CloneCoding.NaverCafe.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, QueryCommentRepository {
}
