package CloneCoding.NaverCafe.domain.article.normal.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QueryNormalRepositoryImpl implements QueryNormalRepository {

    private final JPAQueryFactory query;



}
