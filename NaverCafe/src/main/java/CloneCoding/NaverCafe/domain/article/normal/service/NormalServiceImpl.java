package CloneCoding.NaverCafe.domain.article.normal.service;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import CloneCoding.NaverCafe.domain.article.normal.dto.RequestPostNormal;
import CloneCoding.NaverCafe.domain.article.normal.dto.ResponseNormalForm;
import CloneCoding.NaverCafe.domain.article.normal.dto.ResponseReadNormal;
import CloneCoding.NaverCafe.domain.article.normal.repository.NormalRepository;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.Integrate;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.repository.IntegrateRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static CloneCoding.NaverCafe.domain.article.normal.enums.BasicData.DEFAULT_ARTICLE_URL;
import static CloneCoding.NaverCafe.domain.article.normal.enums.BasicData.LEAVE_COMMENT;
import static CloneCoding.NaverCafe.domain.cafeMember.enums.CafeMemberPosition.changeNameToPosition;
import static CloneCoding.NaverCafe.message.SystemMessage.DELETE_ARTICLE_COMPLETE;
import static CloneCoding.NaverCafe.message.SystemMessage.WRITE_COMPLETE;

@Service
@RequiredArgsConstructor
public class NormalServiceImpl implements NormalService {

    private final NormalRepository normalRepository;
    private final CafeRepository cafeRepository;
    private final CafeMemberRepository cafeMemberRepository;
    private final IntegrateRepository integrateRepository;
    private final AesUtil aesUtil;

    @Override
    public ResponseNormalForm createWriteForm(String url, String token) {
        checkAuth(url, token);
        return new ResponseNormalForm();
    }

    @Override
    public String createNormal(RequestPostNormal request, String url, String token) {

        CafeMember cafeMember = checkAuth(url, token);

        Normal normal = Normal.create(request, cafeMember);

        normalRepository.save(normal);

        return WRITE_COMPLETE.getMessage();

    }

    @Override
    public ResponseNormalForm createUpdateForm(String url, Long id, String token) {

        checkAuth(url, token);

        Normal article = normalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보를 찾을 수 없습니다."));

        Integrate menu = integrateRepository.findById(article.getMenuId())
                .orElseThrow(() -> new NoSuchElementException("통합게시판 정보를 찾을 수 없습니다."));

        return ResponseNormalForm.builder()
                .menu(menu.getName())
                .titleHeader(article.getTitleHeader())
                .title(article.getTitle())
                .body(article.getBody())
                .tag("")
                .notice(article.isNotice())
                .allowComment(article.isAllowComment())
                .build();
    }

    @Override
    public String updateNormal(String url, Long id, RequestPostNormal request, String token) {

        checkAuth(url, token);

        Normal article = normalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보를 찾을 수 없습니다."));

        article.update(request);

        normalRepository.save(article);

        return WRITE_COMPLETE.getMessage();

    }

    @Override
    @Transactional
    public ResponseReadNormal readNormal(String url, Long id, String token) {

        CafeMember reader = checkAuth(url, token);

        Normal article = normalRepository.findByIdWithLock(id)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보를 찾을 수 없습니다."));

        Integrate menu = integrateRepository.findById(article.getMenuId())
                .orElseThrow(() -> new NoSuchElementException("게시판 정보를 찾을 수 없습니다."));

        CafeMember writer = cafeMemberRepository.findByAccountId(article.getCafeId(), article.getAccountId());

        article.addViewCount();

        // 동시성 문제 테스트를 위해 필요한 딜레이
        try {
            Thread.sleep(5000L);
        } catch (Exception e) {
            throw new RuntimeException("기다리는 중");
        }

        Normal updateNormal = normalRepository.save(article);

        return ResponseReadNormal.builder()
                .menuId(menu.getId())
                .menuName(menu.getName())
                .title("[" + article.getTitleHeader() + "] " + article.getTitle())
                .profileImage(writer.getProfileImage())
                .accountId(article.getAccountId())
                .nickname(article.getNickname())
                .position(changeNameToPosition(writer.getPosition()))
                .createAt(article.getCreateAt())
                .viewCount(updateNormal.getViewCount())
                .commentCount(article.getCommentCount())
                .articleUrl(DEFAULT_ARTICLE_URL.getValue() +
                        "/" + article.getCafeId().getUrl() +
                        "/" + article.getId())
                .body(article.getBody())
                .favoriteCount(article.getFavoriteCount())
                .commentNickname(reader.getNickname())
                .defaultComment(LEAVE_COMMENT.getValue())
                .build();
    }

    @Override
    public String delNormal(String url, Long id, String token) {

        CafeMember user = checkAuth(url, token);

        Normal article = normalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보를 찾을 수 없습니다."));

        if (!user.getAccountId().equals(article.getAccountId())) {
            throw new RuntimeException("작성자일 경우 해당 게시글을 삭제할 수 있습니다.");
        }

        normalRepository.delete(article);

        return DELETE_ARTICLE_COMPLETE.getMessage();

    }

    private CafeMember checkAuth(String url, String token) {
        Cafe cafe = cafeRepository.findByUrl(url);
        String accountId = aesUtil.aesDecode(token);

        return cafeMemberRepository.findByAccountId(cafe, accountId);
    }

}
