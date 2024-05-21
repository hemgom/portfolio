package CloneCoding.NaverCafe.domain.cafeMember.service;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.repository.MemberRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeMemberServiceImpl implements CafeMemberService {

    private final CafeMemberRepository cafeMemberRepository;
    private final MemberRepository memberRepository;
    private final AesUtil aesUtil;

    @Override
    public void addCafeManager(String token, Cafe cafe) {

        String accountId = aesUtil.aesDecode(token);
        Member findMember = memberRepository.findByAccountId(accountId);

        CafeMember cafeManager = CafeMember.addCafeManager(
                findMember.getAccountId(), findMember.getNickname(),
                findMember.getGender(), findMember.getBirthday(), cafe);

        cafeMemberRepository.save(cafeManager);

    }

}
