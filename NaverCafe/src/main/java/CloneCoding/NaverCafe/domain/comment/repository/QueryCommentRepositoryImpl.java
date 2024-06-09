package CloneCoding.NaverCafe.domain.comment.repository;

import CloneCoding.NaverCafe.domain.comment.Comment;
import CloneCoding.NaverCafe.domain.comment.QComment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static CloneCoding.NaverCafe.domain.comment.QComment.*;

@Repository
@RequiredArgsConstructor
public class QueryCommentRepositoryImpl implements QueryCommentRepository {

    private final JPAQueryFactory query;

    @Override
    public List<Comment> findByArticleId(Long articleId) {
        return Optional.ofNullable(query
                        .selectFrom(comment)
                        .where(comment.menuId.eq(articleId))
                        .orderBy(comment.createAt.asc(), comment.commentGroup.asc())
                        .fetch())
                .orElseThrow(() -> new NoSuchElementException("댓글 정보를 찾을 수 없습니다."));
    }

}
