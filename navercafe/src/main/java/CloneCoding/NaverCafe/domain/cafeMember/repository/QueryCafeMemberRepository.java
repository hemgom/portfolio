package CloneCoding.NaverCafe.domain.cafeMember.repository;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;

public interface QueryCafeMemberRepository {

    CafeMember findByAccountId(Cafe cafe, String accountId);

}
