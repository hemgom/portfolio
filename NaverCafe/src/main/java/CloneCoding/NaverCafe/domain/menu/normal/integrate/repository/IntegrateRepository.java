package CloneCoding.NaverCafe.domain.menu.normal.integrate.repository;

import CloneCoding.NaverCafe.domain.menu.normal.integrate.Integrate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegrateRepository extends JpaRepository<Integrate, Long>, QueryIntegrateRepository {
}
