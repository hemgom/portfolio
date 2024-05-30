package CloneCoding.NaverCafe.domain.article.normal.repository;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NormalRepository extends JpaRepository<Normal, Long>, QueryNormalRepository {
}
