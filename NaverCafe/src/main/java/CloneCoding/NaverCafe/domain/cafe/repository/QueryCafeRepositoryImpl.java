package CloneCoding.NaverCafe.domain.cafe.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QueryCafeRepositoryImpl implements QueryCafeRepository {

    private final JPAQueryFactory query;

}
