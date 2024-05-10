package CloneCoding.NaverCafe.domain.member.controller;

import CloneCoding.NaverCafe.domain.member.dto.RequestJoinMember;
import CloneCoding.NaverCafe.domain.member.dto.RequestLogin;
import CloneCoding.NaverCafe.domain.member.dto.ResponseMemberInfo;
import CloneCoding.NaverCafe.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public String joinMember(@RequestBody @Valid RequestJoinMember request) {
        log.info("회원 등록 요청");
        return memberService.joinMember(request);
    }

    @GetMapping("/{id}")
    public ResponseMemberInfo readMemberInfo(@PathVariable("id") Long id) {
        log.info("회원 정보 요청");
        return memberService.findMemberInfoById(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody RequestLogin request) {
        log.info("로그인 요청");
        return memberService.login(request);
    }

}