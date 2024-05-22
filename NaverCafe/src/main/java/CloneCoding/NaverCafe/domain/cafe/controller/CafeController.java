package CloneCoding.NaverCafe.domain.cafe.controller;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.dto.RequestCreateCafe;
import CloneCoding.NaverCafe.domain.cafe.service.CafeService;
import CloneCoding.NaverCafe.domain.cafeMember.service.CafeMemberService;
import CloneCoding.NaverCafe.domain.keyword.service.KeywordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import static CloneCoding.NaverCafe.message.SystemMessage.CREATE_CAFE_COMPLETE;

@Slf4j
@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/cafe")
public class CafeController {

    private final CafeService cafeService;

    @PostMapping("/create")
    public String createCafe(@RequestBody @Valid RequestCreateCafe request,
                             @RequestHeader("Authorization") String token) {
        log.info("카페 생성 요청");

        return cafeService.createCafe(request, token);
    }

}
