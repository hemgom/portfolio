package CloneCoding.NaverCafe.domain.member.repository;

import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.dto.RequestJoinMember;

public interface QueryMemberRepository {

    Member join(RequestJoinMember request);

}