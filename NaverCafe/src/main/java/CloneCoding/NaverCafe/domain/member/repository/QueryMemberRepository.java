package CloneCoding.NaverCafe.domain.member.repository;

import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.dto.RequestJoinMember;
import CloneCoding.NaverCafe.domain.member.dto.ResponseMemberInfo;

public interface QueryMemberRepository {

    Member join(RequestJoinMember request);

    ResponseMemberInfo makeResponseMemberInfo(Member member);

}