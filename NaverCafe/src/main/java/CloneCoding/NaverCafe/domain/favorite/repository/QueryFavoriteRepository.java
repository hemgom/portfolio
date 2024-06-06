package CloneCoding.NaverCafe.domain.favorite.repository;

import CloneCoding.NaverCafe.domain.favorite.Favorite;

public interface QueryFavoriteRepository {

    Favorite findByAccountId(String accountId);

}
