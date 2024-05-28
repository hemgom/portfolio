package CloneCoding.NaverCafe.domain.bulletinBoard.service;

import CloneCoding.NaverCafe.domain.bulletinBoard.repository.BulletinBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BulletinBoardServiceImpl implements BulletinBoardService {

    private final BulletinBoardRepository bulletinBoardRepository;

}
