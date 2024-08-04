package CloneCoding.NaverCafe.domain.cafe.service;

import CloneCoding.NaverCafe.domain.cafe.dto.RequestCreateCafe;
import CloneCoding.NaverCafe.domain.cafe.dto.ResponseCreateForm;

public interface CafeService {

    ResponseCreateForm createForm(String token);

    String createCafe(RequestCreateCafe request, String token);

}
