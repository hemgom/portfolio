package CloneCoding.NaverCafe.domain.comment.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QueryCommentRepositoryImpl implements QueryCommentRepository {

    private final JPAQueryFactory query;

}
