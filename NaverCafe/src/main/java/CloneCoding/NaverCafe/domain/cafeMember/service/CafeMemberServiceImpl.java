package CloneCoding.NaverCafe.domain.cafeMember.service;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestJoinCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestUpdateCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.ResponseJoinForm;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.repository.MemberRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static CloneCoding.NaverCafe.domain.cafe.BasicURL.BASIC_URL;
import static CloneCoding.NaverCafe.message.SystemMessage.*;

@Service
@RequiredArgsConstructor
public class CafeMemberServiceImpl implements CafeMemberService {

    private final CafeMemberRepository cafeMemberRepository;
    private final CafeRepository cafeRepository;
    private final MemberRepository memberRepository;
    private final AesUtil aesUtil;

    public ResponseJoinForm createJoinForm(String url, String token) {

        checkCafe(BASIC_URL.getUrl() + url);

        String accountId = aesUtil.aesDecode(token);
        Member findMember = memberRepository.findByAccountId(accountId);

        return new ResponseJoinForm(findMember.getNickname());

    }

    @Override
    public String joinCafeMember(RequestJoinCafeMember request, String token) {

        Cafe findCafe = checkCafe(request.getUrl());
        Member findMember = checkMember(token);

        CafeMember cafeMember = CafeMember.createCafeMember(request.getCafeMemberInfo(), findCafe, findMember);

        if (checkNicknameUnique(findCafe, cafeMember.getNickname())) {
            cafeMemberRepository.save(cafeMember);
        } else {
            return NICKNAME_NOT_UNIQUE.getMessage();
        }

        return JOIN_COMPLETE_CAFE.getMessage();

    }

    @Override
    public String updateCafeMember(RequestUpdateCafeMember request, String token) {

        if (!request.getUpdateCafeMemberInfo().getNickname().isEmpty()) {

        }

        Cafe findCafe = checkCafe(request.getUrl());
        CafeMember findCafeMember = checkCafeMember(findCafe, token);

        findCafeMember.update(request.getUpdateCafeMemberInfo());

        cafeMemberRepository.save(findCafeMember);

        return UPDATE_CAFE_MEMBER_INFO.getMessage();

    }

    private Cafe checkCafe(String url) {
        return cafeRepository.findByUrl(url);
    }

    private Member checkMember(String token) {
        String accountId = aesUtil.aesDecode(token);
        return memberRepository.findByAccountId(accountId);
    }

    private boolean checkNicknameUnique(Cafe cafe, String nickname) {
        CafeMember findCafeMember = cafeMemberRepository.checkNicknameUnique(cafe, nickname);
        return findCafeMember == null;
    }

    private CafeMember checkCafeMember(Cafe cafe, String token) {
        String accountId = aesUtil.aesDecode(token);
        return cafeMemberRepository.findByAccountId(cafe, accountId);
    }

}
