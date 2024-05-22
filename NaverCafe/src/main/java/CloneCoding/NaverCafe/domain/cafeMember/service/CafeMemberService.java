package CloneCoding.NaverCafe.domain.cafeMember.service;

import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestJoinCafeMember;

public interface CafeMemberService {

    String joinCafeMember(RequestJoinCafeMember request, String token);

}
