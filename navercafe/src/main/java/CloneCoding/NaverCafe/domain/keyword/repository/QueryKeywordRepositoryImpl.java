package CloneCoding.NaverCafe.domain.keyword.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QueryKeywordRepositoryImpl implements QueryKeywordRepository {

    private final JPAQueryFactory query;



}
