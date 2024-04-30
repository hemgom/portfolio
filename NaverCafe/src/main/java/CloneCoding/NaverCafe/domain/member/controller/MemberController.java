package CloneCoding.NaverCafe.domain.member.controller;

import CloneCoding.NaverCafe.domain.member.dto.RequestJoinMember;
import CloneCoding.NaverCafe.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}