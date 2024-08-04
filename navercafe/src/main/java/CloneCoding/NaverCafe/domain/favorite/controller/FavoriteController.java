package CloneCoding.NaverCafe.domain.favorite.controller;

import CloneCoding.NaverCafe.domain.favorite.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe/{cafe_url}/{normal_id}")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/favorite")
    public String addFavorite(@PathVariable("cafe_url") String url,
                              @PathVariable("normal_id") Long id,
                              @RequestHeader("Authorization") String token) {
        log.info("게시글 좋아요 추가 요청");
        return favoriteService.addFavorite(url, id, token);
    }

    @DeleteMapping("/favorite")
    public String subFavorite(@PathVariable("cafe_url") String url,
                              @PathVariable("normal_id") Long id,
                              @RequestHeader("Authorization") String token) {
        log.info("게시글 좋아요 취소 요청");
        return favoriteService.subFavorite(url, id, token);
    }

}
