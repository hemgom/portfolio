package CloneCoding.NaverCafe.domain.favorite.service;

public interface FavoriteService {

    String addFavorite(String url, Long id, String token);

    String subFavorite(String url, Long id, String token);

}
