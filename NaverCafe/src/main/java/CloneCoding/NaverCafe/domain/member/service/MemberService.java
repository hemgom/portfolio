package CloneCoding.NaverCafe.domain.member.service;

import CloneCoding.NaverCafe.domain.member.dto.RequestUpdateAccountPassword;
import CloneCoding.NaverCafe.domain.member.dto.*;

public interface MemberService {

    String joinMember(RequestJoinMember request);

    ResponseMemberInfo findMemberInfoById(Long id);

    ResponseLogin login(RequestLogin request);

    String logout(String token);

    ResponseMemberInfo updateMemberInfo(RequestUpdateMember request, String token);

    String updateAccountPassword(RequestUpdateAccountPassword request, String token);

    String deleteMember(String token);

}