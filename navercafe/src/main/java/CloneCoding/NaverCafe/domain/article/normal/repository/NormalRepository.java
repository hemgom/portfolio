package CloneCoding.NaverCafe.domain.article.normal.repository;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NormalRepository extends JpaRepository<Normal, Long>, QueryNormalRepository {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select n from Normal n where n.id = :id")
    Optional<Normal> findByIdWithLock(Long id);

}
