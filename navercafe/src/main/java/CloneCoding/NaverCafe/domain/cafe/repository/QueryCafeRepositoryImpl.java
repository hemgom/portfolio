package CloneCoding.NaverCafe.domain.cafe.repository;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

import static CloneCoding.NaverCafe.domain.cafe.QCafe.cafe;

@Repository
@RequiredArgsConstructor
public class QueryCafeRepositoryImpl implements QueryCafeRepository {

    private final JPAQueryFactory query;

    @Override
    public Cafe findByUrl(String url) {
        return Optional.ofNullable(query
                        .selectFrom(cafe)
                        .where(cafe.url.eq(url))
                        .fetchOne())
                .orElseThrow(() -> new NoSuchElementException("유효하지 않은 카페 URL 주소입니다."));
    }

}
