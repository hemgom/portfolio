package CloneCoding.NaverCafe.domain.cafeMember.repository;

import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeMemberRepository extends JpaRepository<CafeMember, Long>, QueryCafeMemberRepository {
}