package CloneCoding.NaverCafe.domain.member.service;

import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.dto.RequestJoinMember;
import CloneCoding.NaverCafe.domain.member.dto.RequestLogin;
import CloneCoding.NaverCafe.domain.member.dto.ResponseMemberInfo;
import CloneCoding.NaverCafe.domain.member.repository.MemberRepository;
import CloneCoding.NaverCafe.message.SystemMessage;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static CloneCoding.NaverCafe.message.Login.STATUS_LOGIN;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final AesUtil aesUtil;

    @Override
    public String joinMember(RequestJoinMember request) {

        Member joinMember = memberRepository.join(request);
        memberRepository.save(joinMember);

        return SystemMessage.JOIN_COMPLETE_NAVER.getMessage();

    }

    @Override
    public ResponseMemberInfo findMemberInfoById(Long id) {

        Member findMember = memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("id가 일치하는 회원을 찾을 수 없습니다."));

        return memberRepository.makeResponseMemberInfo(findMember);

    }

    @Override
    public String login(RequestLogin request) {

        Member findMember = memberRepository.findByAccount(request);
        findMember.setLoginStatus(STATUS_LOGIN.getStatus());
        findMember.setToken(aesUtil.aesEncode(findMember.getAccountId()));
        memberRepository.save(findMember);

        return SystemMessage.LOGIN_COMPLETE.getMessage();

    }

}