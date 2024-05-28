package CloneCoding.NaverCafe.domain.bulletinBoard.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QueryBulletinBoardRepositoryImpl implements QueryBulletinBoardRepository {

    private final JPAQueryFactory query;

}
