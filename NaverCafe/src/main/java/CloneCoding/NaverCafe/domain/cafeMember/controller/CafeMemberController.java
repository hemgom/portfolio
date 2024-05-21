package CloneCoding.NaverCafe.domain.cafeMember.controller;

import CloneCoding.NaverCafe.domain.cafeMember.service.CafeMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cafeMember")
public class CafeMemberController {

    private final CafeMemberService cafeMemberService;

}
