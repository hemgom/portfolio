package CloneCoding.NaverCafe.domain.cafe.service;

import CloneCoding.NaverCafe.domain.cafe.dto.RequestCreateCafe;

public interface CafeService {

    String createCafe(RequestCreateCafe request, String token);

}
