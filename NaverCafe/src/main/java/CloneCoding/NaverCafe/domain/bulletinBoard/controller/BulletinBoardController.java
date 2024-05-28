package CloneCoding.NaverCafe.domain.bulletinBoard.controller;

import CloneCoding.NaverCafe.domain.bulletinBoard.service.BulletinBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BulletinBoardController {

    private final BulletinBoardService bulletinBoardService;

}
