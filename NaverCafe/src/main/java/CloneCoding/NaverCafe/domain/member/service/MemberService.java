package CloneCoding.NaverCafe.domain.member.service;

import CloneCoding.NaverCafe.domain.member.dto.RequestJoinMember;
import CloneCoding.NaverCafe.domain.member.dto.RequestLogin;
import CloneCoding.NaverCafe.domain.member.dto.ResponseLogin;
import CloneCoding.NaverCafe.domain.member.dto.ResponseMemberInfo;

public interface MemberService {

    String joinMember(RequestJoinMember request);

    ResponseMemberInfo findMemberInfoById(Long id);

    ResponseLogin login(RequestLogin request);

    String logout(String token);

}