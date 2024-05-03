package CloneCoding.NaverCafe.domain.member.service;

import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    MemberRepository memberRepository;

    @DisplayName("회원가입 테스트")
    @Test
    void joinMember() {
        // given
        LocalDate birthday = LocalDate.of(2000, 2, 20);
        Member member = new Member(1L, "java", "0000",
                "testEmail@test.com", "Kim",
                birthday, "01055558888", "intellij");

        // when
        Member joinMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(1L)
                .orElseThrow(() -> new NoSuchElementException("id와 일치하는 회원이 없습니다."));

        // then
        assertThat(findMember).isEqualTo(joinMember);
    }

}