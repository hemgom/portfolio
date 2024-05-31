package CloneCoding.NaverCafe.domain.article.normal.controller;

import CloneCoding.NaverCafe.domain.article.normal.dto.RequestPostNormal;
import CloneCoding.NaverCafe.domain.article.normal.dto.ResponseNormalForm;
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
    public ResponseNormalForm getWriteForm(@PathVariable("cafe_url") String url,
                                           @RequestHeader("Authorization") String token) {
        log.info("게시글 기본 작성양식 가져오기 요청");
        return normalService.createWriteForm(url, token);
    }

    @PostMapping("/write")
    public String writeArticle(@PathVariable("cafe_url") String url,
                               @RequestBody @Valid RequestPostNormal request,
                               @RequestHeader("Authorization") String token) {
        log.info("게시글 등록 요청");
        return normalService.createNormal(request, url, token);
    }

    @GetMapping("/update/{normal_id}")
    public ResponseNormalForm getUpdateForm(@PathVariable("cafe_url") String url,
                                            @PathVariable("normal_id") Long id,
                                            @RequestHeader("Authorization") String token) {
        log.info("게시글 수정양식 가져오기 요청");
        return normalService.createUpdateForm(url, id, token);
    }

    @PutMapping("/update/{normal_id}")
    public String updateArticle(@PathVariable("cafe_url") String url,
                                @PathVariable("normal_id") Long id,
                                @RequestBody @Valid RequestPostNormal request,
                                @RequestHeader("Authorization") String token) {
        log.info("게시글 수정 요청");
        return normalService.updateNormal(url, id, request, token);
    }

}
