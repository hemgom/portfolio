package CloneCoding.NaverCafe.domain.bulletinBoard.repository;

import CloneCoding.NaverCafe.domain.bulletinBoard.BulletinBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BulletinBoardRepository extends JpaRepository<BulletinBoard, Long>, QueryBulletinBoardRepository {
}
