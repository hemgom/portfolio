package CloneCoding.NaverCafe.domain.cafeMember.service;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestJoinCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestUpdateCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.ResponseJoinForm;
import CloneCoding.NaverCafe.domain.cafeMember.dto.ResponseUpdateForm;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.repository.MemberRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static CloneCoding.NaverCafe.message.SystemMessage.*;

@Service
@RequiredArgsConstructor
public class CafeMemberServiceImpl implements CafeMemberService {

    private final CafeMemberRepository cafeMemberRepository;
    private final CafeRepository cafeRepository;
    private final MemberRepository memberRepository;
    private final AesUtil aesUtil;

    @Override
    public ResponseJoinForm createJoinForm(String url, String token) {

        checkCafe(url);
        Member findMember = checkMember(token);

        return new ResponseJoinForm(findMember.getNickname());

    }

    @Override
    public String joinCafeMember(String url, RequestJoinCafeMember request, String token) {

        Cafe findCafe = checkCafe(url);
        Member findMember = checkMember(token);

        CafeMember cafeMember = CafeMember.createCafeMember(request, findCafe, findMember);

        cafeMemberRepository.save(cafeMember);

        return JOIN_COMPLETE_CAFE.getMessage();

    }

    @Override
    public ResponseUpdateForm createUpdateForm(String url, String token) {

        Cafe findCafe = checkCafe(url);
        CafeMember findCafeMember = checkCafeMember(findCafe, token);

        return ResponseUpdateForm.builder()
                .profileImage(findCafeMember.getProfileImage())
                .nickname(findCafeMember.getNickname())
                .description(findCafeMember.getDescription())
                .genderAgeOpen(findCafeMember.isGenderAgeOpen())
                .myBlogOpen(findCafeMember.isMyBlogOpen())
                .popularMemberPush(findCafeMember.isPopularMemberPush())
                .build();
    }

    @Override
    public String updateCafeMember(String url, RequestUpdateCafeMember request, String token) {

        Cafe findCafe = checkCafe(url);
        CafeMember findCafeMember = checkCafeMember(findCafe, token);

        findCafeMember.update(request);

        cafeMemberRepository.save(findCafeMember);

        return UPDATE_CAFE_MEMBER_INFO.getMessage();

    }

    @Override
    public String deleteCafeMember(String url, String token) {

        Cafe findcafe = checkCafe(url);
        CafeMember findCafeMember = checkCafeMember(findcafe, token);

        cafeMemberRepository.delete(findCafeMember);

        return DELETE_CAFE_MEMBER_COMPLETE.getMessage();

    }

    private Cafe checkCafe(String url) {
        return cafeRepository.findByUrl(url);
    }

    private Member checkMember(String token) {
        String accountId = aesUtil.aesDecode(token);
        return memberRepository.findByAccountId(accountId);
    }

    private CafeMember checkCafeMember(Cafe cafe, String token) {
        String accountId = aesUtil.aesDecode(token);
        return cafeMemberRepository.findByAccountId(cafe, accountId);
    }

}
