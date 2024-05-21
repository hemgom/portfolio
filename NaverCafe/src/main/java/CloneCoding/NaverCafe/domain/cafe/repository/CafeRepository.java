package CloneCoding.NaverCafe.domain.cafe.repository;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long>, QueryCafeRepository {
}
