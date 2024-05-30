package CloneCoding.NaverCafe.domain.article.normal.service;

import CloneCoding.NaverCafe.domain.article.normal.dto.RequestWriteNormal;
import CloneCoding.NaverCafe.domain.article.normal.dto.ResponseWriteFormNormal;

public interface NormalService {

    ResponseWriteFormNormal createWriteForm(String url, String token);

    String createNormal(RequestWriteNormal request, String url, String token);

}
