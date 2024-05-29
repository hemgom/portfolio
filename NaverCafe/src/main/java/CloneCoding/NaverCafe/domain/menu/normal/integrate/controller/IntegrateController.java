package CloneCoding.NaverCafe.domain.menu.normal.integrate.controller;

import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.RequestCreateIntegrate;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.RequestUpdateIntegrate;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.ResponseCreateForm;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.ResponseUpdateForm;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.service.IntegrateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/manageMenu")
public class IntegrateController {

    private final IntegrateService integrateService;

    @GetMapping("/create")
    public ResponseCreateForm getCreateForm(@RequestHeader("Authorization") String token) {
        log.info("일반 게시판(통합게시판) 생성 양식 요청");
        return integrateService.createIntegrateForm(token);
    }

    @PostMapping("/create/{cafe_url}")
    public String createIntegrate(@PathVariable("cafe_url") String url,
                                  @RequestBody @Valid RequestCreateIntegrate request,
                                  @RequestHeader("Authorization") String token) {
        log.info("일반 게시판(통합게시판) 생성 요청");
        return integrateService.createIntegrate(request, url, token);
    }

    @GetMapping("/update/{integrate_id}")
    public ResponseUpdateForm getUpdateForm(@PathVariable("integrate_id") Long id,
                                            @RequestHeader("Authorization") String token) {
        log.info("일반 게시판(통합게시판) 수정 양식 요청");
        return integrateService.createIntegrateUpdateForm(id, token);
    }

    @PutMapping("/update/{integrate_id}")
    public String updateIntegrate(@PathVariable("integrate_id") Long id,
                                  @RequestBody @Valid RequestUpdateIntegrate request,
                                  @RequestHeader("Authorization") String token) {

        log.info("일반 게시판(통합게시판) 수정 요청");
        return integrateService.updateIntegrate(request, id, token);
    }

}
