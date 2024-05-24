package CloneCoding.NaverCafe.domain.cafe.controller;

import CloneCoding.NaverCafe.domain.cafe.dto.RequestCreateCafe;
import CloneCoding.NaverCafe.domain.cafe.dto.ResponseCreateForm;
import CloneCoding.NaverCafe.domain.cafe.service.CafeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/cafe")
public class CafeController {

    private final CafeService cafeService;

    @GetMapping("/create")
    public ResponseCreateForm getCreateForm(@RequestHeader("Authorization") String token) {
        log.info("카페 생성 양식 요청");
        return cafeService.createForm(token);
    }

    @PostMapping("/create")
    public String createCafe(@RequestBody @Valid RequestCreateCafe request,
                             @RequestHeader("Authorization") String token) {
        log.info("카페 생성 요청");

        return cafeService.createCafe(request, token);
    }

}
