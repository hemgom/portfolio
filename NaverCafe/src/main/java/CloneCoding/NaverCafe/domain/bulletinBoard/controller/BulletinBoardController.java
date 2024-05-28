package CloneCoding.NaverCafe.domain.bulletinBoard.controller;

import CloneCoding.NaverCafe.domain.bulletinBoard.dto.RequestCreateGeneralBulletinBoard;
import CloneCoding.NaverCafe.domain.bulletinBoard.dto.ResponseGeneralCreateForm;
import CloneCoding.NaverCafe.domain.bulletinBoard.service.BulletinBoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/manageMenu")
public class BulletinBoardController {

    private final BulletinBoardService bulletinBoardService;

    @GetMapping("/create/general")
    public ResponseGeneralCreateForm getGeneralCreateForm(@RequestHeader("Authorization") String token) {
        log.info("일반 게시판(통합게시판) 생성 양식 요청");
        return bulletinBoardService.createGeneralForm(token);
    }

    @PostMapping("/create/general/{cafe_url}")
    public String createGeneralBulletinBoard(@PathVariable("cafe_url") String url,
                                             @RequestBody @Valid RequestCreateGeneralBulletinBoard request,
                                             @RequestHeader("Authorization") String token) {
        log.info("일반 게시판(통합게시판) 생성 요청");
        return bulletinBoardService.createGeneralBulletinBoard(request, url, token);
    }

}
