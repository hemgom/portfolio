package CloneCoding.NaverCafe.domain.bulletinBoard.service;

import CloneCoding.NaverCafe.domain.bulletinBoard.dto.RequestCreateGeneralBulletinBoard;
import CloneCoding.NaverCafe.domain.bulletinBoard.dto.ResponseGeneralCreateForm;

public interface BulletinBoardService {

    ResponseGeneralCreateForm createGeneralForm(String token);

    String createGeneralBulletinBoard(RequestCreateGeneralBulletinBoard request, String url, String token);

}
