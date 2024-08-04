package CloneCoding.NaverCafe.domain.favorite.repository;

import CloneCoding.NaverCafe.domain.favorite.Favorite;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

import static CloneCoding.NaverCafe.domain.favorite.QFavorite.favorite;

@Repository
@RequiredArgsConstructor
public class QueryFavoriteRepositoryImpl implements QueryFavoriteRepository {

    private final JPAQueryFactory query;

    @Override
    public Favorite findByAccountId(String accountId) {
        return Optional.ofNullable(query
                        .selectFrom(favorite)
                        .where(favorite.accountId.eq(accountId))
                        .fetchOne())
                .orElseThrow(() -> new NoSuchElementException("좋아요 정보를 찾을 수 없습니다."));
    }

}
