package CloneCoding.NaverCafe.domain.member.controller;

import CloneCoding.NaverCafe.domain.member.dto.RequestJoinMember;
import CloneCoding.NaverCafe.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public String joinMember(@RequestBody RequestJoinMember request) {
        return memberService.joinMember(request);
    }

}