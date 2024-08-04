package CloneCoding.NaverCafe.domain.article.normal.service;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import CloneCoding.NaverCafe.domain.article.normal.repository.NormalRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class NormalServiceImplTest {

    @Autowired
    NormalRepository normalRepository;

    @DisplayName("조회수 동시성 테스트")
    @Test
    void viewCountTest() {
        // given
        Normal test = Normal.builder()
                .menuId(1L)
                .title("테스트 게시글 입니다.")
                .titleHeader("[공지사항]")
                .body("테스트를 위해 작성한 게시글 입니다.")
                .notice(true)
                .allowComment(false)
                .accountId("springFramework")
                .nickname("java")
                .createAt(LocalDateTime.now())
                .build();

        normalRepository.save(test);

        // when
        Normal requestA = normalRepository.findByIdWithLock(1L)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보 없음"));

        Normal requestB = normalRepository.findByIdWithLock(1L)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보 없음"));

        requestA.addViewCount();    // 1
        requestB.addViewCount();    // 1

        Normal resultA = normalRepository.save(requestA);
        Normal resultB = normalRepository.save(requestB);

        // then
        assertThat(resultB.getViewCount()).isEqualTo(2);

    }

}