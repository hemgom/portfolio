package CloneCoding.NaverCafe.domain.favorite.service;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import CloneCoding.NaverCafe.domain.article.normal.repository.NormalRepository;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.favorite.Favorite;
import CloneCoding.NaverCafe.domain.favorite.repository.FavoriteRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static CloneCoding.NaverCafe.message.SystemMessage.ADD_FAVORITE_COMPLETE;
import static CloneCoding.NaverCafe.message.SystemMessage.SUB_FAVORITE_COMPLETE;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final CafeRepository cafeRepository;
    private final NormalRepository normalRepository;
    private final CafeMemberRepository cafeMemberRepository;
    private final AesUtil aesUtil;

    @Transactional
    @Override
    public String addFavorite(String url, Long id, String token) {

        CafeMember user = checkCafeMember(url, token);
        Normal article = normalRepository.findByIdWithLock(id)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보를 찾을 수 없습니다."));

        Favorite favorite = Favorite.create(user, article);
        article.addFavoriteCount();

        favoriteRepository.save(favorite);
        normalRepository.save(article);

        return ADD_FAVORITE_COMPLETE.getMessage();

    }

    @Transactional
    @Override
    public String subFavorite(String url, Long id, String token) {

        CafeMember user = checkCafeMember(url, token);
        Normal article = normalRepository.findByIdWithLock(id)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보를 찾을 수 없습니다."));

        Favorite findFavorite = favoriteRepository.findByAccountId(user.getAccountId());
        article.subFavoriteCount();

        favoriteRepository.delete(findFavorite);
        normalRepository.save(article);

        return SUB_FAVORITE_COMPLETE.getMessage();

    }

    private CafeMember checkCafeMember(String url, String token) {
        String accountId = aesUtil.aesDecode(token);
        Cafe findCafe = cafeRepository.findByUrl(url);
        return cafeMemberRepository.findByAccountId(findCafe, accountId);
    }

}
