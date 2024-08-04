package CloneCoding.NaverCafe.domain.tag.repository;

import CloneCoding.NaverCafe.domain.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long>, QueryTagRepository {
}
