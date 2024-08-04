package CloneCoding.NaverCafe.domain.cafeMember.repository;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.QCafeMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

import static CloneCoding.NaverCafe.domain.cafeMember.QCafeMember.*;

@Repository
@RequiredArgsConstructor
public class QueryCafeMemberRepositoryImpl implements QueryCafeMemberRepository {

    private final JPAQueryFactory query;

    @Override
    public CafeMember findByAccountId(Cafe cafe, String accountId) {
        return Optional.ofNullable(query
                        .selectFrom(cafeMember)
                        .where(cafeMember.cafeId.eq(cafe), cafeMember.accountId.eq(accountId))
                        .fetchOne())
                .orElseThrow(() -> new NoSuchElementException("해당 계정 정보를 가진 카페 회원이 존재하지 않습니다."));
    }

}
