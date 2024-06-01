package CloneCoding.NaverCafe.domain.article.normal.service;

import CloneCoding.NaverCafe.domain.article.normal.dto.RequestPostNormal;
import CloneCoding.NaverCafe.domain.article.normal.dto.ResponseNormalForm;
import CloneCoding.NaverCafe.domain.article.normal.dto.ResponseReadNormal;

public interface NormalService {

    ResponseNormalForm createWriteForm(String url, String token);

    String createNormal(RequestPostNormal request, String url, String token);

    ResponseNormalForm createUpdateForm(String url, Long id, String token);

    String updateNormal(String url, Long id, RequestPostNormal request, String token);

    ResponseReadNormal readNormal(String url, Long id, String token);

}
