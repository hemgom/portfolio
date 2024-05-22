package CloneCoding.NaverCafe.domain.cafeMember.service;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestJoinCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.repository.MemberRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static CloneCoding.NaverCafe.message.SystemMessage.JOIN_COMPLETE_CAFE;

@Service
@RequiredArgsConstructor
public class CafeMemberServiceImpl implements CafeMemberService {

    private final CafeMemberRepository cafeMemberRepository;
    private final CafeRepository cafeRepository;
    private final MemberRepository memberRepository;
    private final AesUtil aesUtil;

    @Override
    public String joinCafeMember(RequestJoinCafeMember request, String token) {

        Cafe findCafe = cafeRepository.findByUrl(request.getUrl());

        String accountId = aesUtil.aesDecode(token);
        Member findMember = memberRepository.findByAccountId(accountId);

        CafeMember cafeMember = CafeMember.createCafeMember(request.getCafeMemberInfo(), findCafe, findMember);

        cafeMemberRepository.save(cafeMember);

        return JOIN_COMPLETE_CAFE.getMessage();

    }

}
