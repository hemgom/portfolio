package CloneCoding.NaverCafe.domain.cafeMember.controller;

import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestJoinCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.service.CafeMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cafeMember")
public class CafeMemberController {

    private final CafeMemberService cafeMemberService;

    @PostMapping("/join")
    public String joinCafeMember(@RequestBody @Valid RequestJoinCafeMember request,
                                 @RequestHeader("Authorization") String token) {
        log.info("카페 회원 가입 요청");
        return cafeMemberService.joinCafeMember(request, token);
    }

}
