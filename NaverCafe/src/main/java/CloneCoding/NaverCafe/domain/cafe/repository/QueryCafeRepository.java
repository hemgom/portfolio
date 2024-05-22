package CloneCoding.NaverCafe.domain.cafe.repository;

import CloneCoding.NaverCafe.domain.cafe.Cafe;

public interface QueryCafeRepository {

    Cafe findByUrl(String url);

}
