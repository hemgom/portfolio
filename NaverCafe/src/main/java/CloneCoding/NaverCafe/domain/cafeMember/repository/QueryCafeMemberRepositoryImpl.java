package CloneCoding.NaverCafe.domain.cafeMember.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QueryCafeMemberRepositoryImpl implements QueryCafeMemberRepository {

    private final JPAQueryFactory query;

}
