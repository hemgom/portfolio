package CloneCoding.NaverCafe.domain.cafeMember.service;

import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestJoinCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestUpdateCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.ResponseJoinForm;

public interface CafeMemberService {

    ResponseJoinForm createJoinForm(String url, String token);

    String joinCafeMember(RequestJoinCafeMember request, String token);

    String updateCafeMember(RequestUpdateCafeMember request, String token);

}
