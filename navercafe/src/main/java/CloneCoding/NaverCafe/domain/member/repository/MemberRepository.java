package CloneCoding.NaverCafe.domain.member.repository;

import CloneCoding.NaverCafe.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, QueryMemberRepository {
}
