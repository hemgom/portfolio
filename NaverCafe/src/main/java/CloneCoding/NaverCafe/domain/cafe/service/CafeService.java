package CloneCoding.NaverCafe.domain.cafe.service;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.dto.RequestCreateCafe;

public interface CafeService {

    Cafe createCafe(RequestCreateCafe.CafeInfo request);

}
