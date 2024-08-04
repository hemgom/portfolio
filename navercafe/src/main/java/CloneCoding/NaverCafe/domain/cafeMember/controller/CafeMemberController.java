package CloneCoding.NaverCafe.domain.cafeMember.controller;

import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestJoinCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.RequestUpdateCafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.dto.ResponseJoinForm;
import CloneCoding.NaverCafe.domain.cafeMember.dto.ResponseUpdateForm;
import CloneCoding.NaverCafe.domain.cafeMember.service.CafeMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/{cafe_url}")
public class CafeMemberController {

    private final CafeMemberService cafeMemberService;

    @GetMapping("/join")
    public ResponseJoinForm getJoinForm(@PathVariable("cafe_url") String url,
                                        @RequestHeader("Authorization") String token) {
        log.info("카페 회원가입 양식 요청");
        return cafeMemberService.createJoinForm(url, token);
    }

    @PostMapping("/join")
    public String joinCafeMember(@PathVariable("cafe_url") String url,
                                 @RequestBody @Valid RequestJoinCafeMember request,
                                 @RequestHeader("Authorization") String token) {
        log.info("카페 회원가입 요청");
        return cafeMemberService.joinCafeMember(url, request, token);
    }

    @GetMapping("/update")
    public ResponseUpdateForm getUpdateForm(@PathVariable("cafe_url") String url,
                                            @RequestHeader("Authorization") String token) {
        log.info("카페 회원정보 수정 양식 요청");
        return cafeMemberService.createUpdateForm(url, token);
    }

    @PutMapping("/update")
    public String updateCafeMember(@PathVariable("cafe_url") String url,
                                   @RequestBody @Valid RequestUpdateCafeMember request,
                                   @RequestHeader("Authorization") String token) {
        log.info("카페 회원정보 수정 요청");
        return cafeMemberService.updateCafeMember(url, request, token);
    }

    @DeleteMapping()
    public String deleteCafeMember(@PathVariable("cafe_url") String url,
                                   @RequestHeader("Authorization") String token) {
        log.info("카페 회원 탈퇴");
        return cafeMemberService.deleteCafeMember(url, token);
    }

}
