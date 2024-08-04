package CloneCoding.NaverCafe.domain.cafeMember.service;

import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestJoinCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestUpdateCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.ResponseJoinForm;
import CloneCoding.NaverCafe.domain.cafeMember.dto.ResponseUpdateForm;

public interface CafeMemberService {

    ResponseJoinForm createJoinForm(String url, String token);

    String joinCafeMember(String url, RequestJoinCafeMember request, String token);

    ResponseUpdateForm createUpdateForm(String url, String token);

    String updateCafeMember(String url, RequestUpdateCafeMember request, String token);

    String deleteCafeMember(String url, String token);

}
