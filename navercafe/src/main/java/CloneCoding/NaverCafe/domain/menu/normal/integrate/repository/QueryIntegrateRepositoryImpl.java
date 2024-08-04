package CloneCoding.NaverCafe.domain.menu.normal.integrate.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QueryIntegrateRepositoryImpl implements QueryIntegrateRepository {

    private final JPAQueryFactory query;

}
