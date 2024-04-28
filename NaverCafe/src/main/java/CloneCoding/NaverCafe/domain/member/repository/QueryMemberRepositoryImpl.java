package CloneCoding.NaverCafe.domain.member.repository;

import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.dto.RequestJoinMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@RequiredArgsConstructor
public class QueryMemberRepositoryImpl implements QueryMemberRepository {

    private final JPAQueryFactory query;

    @Override
    public Member join(RequestJoinMember request) {
        LocalDate birth = LocalDate.of(request.getYear(), request.getMonth(), request.getDay());

        return Member.builder()
                .accountId(request.getAccountId())
                .accountPassword(request.getAccountPassword())
                .email(request.getEmail())
                .username(request.getUsername())
                .birthday(birth)
                .phoneNumber(request.getPhoneNumber())
                .nickname(request.getNickname())
                .build();
    }

}
