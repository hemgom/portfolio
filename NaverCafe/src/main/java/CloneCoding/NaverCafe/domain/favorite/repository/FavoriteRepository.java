package CloneCoding.NaverCafe.domain.favorite.repository;

import CloneCoding.NaverCafe.domain.favorite.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>, QueryFavoriteRepository {
}
