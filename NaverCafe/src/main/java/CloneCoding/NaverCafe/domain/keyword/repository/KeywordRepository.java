package CloneCoding.NaverCafe.domain.keyword.repository;

import CloneCoding.NaverCafe.domain.keyword.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long>, QueryKeywordRepository {
}
