package CloneCoding.NaverCafe.domain.article.normal.controller;

import CloneCoding.NaverCafe.domain.article.normal.dto.RequestWriteNormal;
import CloneCoding.NaverCafe.domain.article.normal.dto.ResponseWriteFormNormal;
import CloneCoding.NaverCafe.domain.article.normal.service.NormalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe/{cafe_url}")
public class NormalController {

    private final NormalService normalService;

    @GetMapping("/write")
    public ResponseWriteFormNormal getWriteForm(@PathVariable("cafe_url") String url,
                                                @RequestHeader("Authorization") String token) {
        log.info("게시글 기본 작성양식 가져오기 요청");
        return normalService.createWriteForm(url, token);
    }

    @PostMapping("/write")
    public String writeArticle(@PathVariable("cafe_url") String url,
                               @RequestBody @Valid RequestWriteNormal request,
                               @RequestHeader("Authorization") String token) {
        log.info("게시글 등록 요청");
        return normalService.createNormal(request, url, token);
    }

}
