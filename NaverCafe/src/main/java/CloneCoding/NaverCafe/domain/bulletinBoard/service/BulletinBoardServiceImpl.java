package CloneCoding.NaverCafe.domain.bulletinBoard.service;

import CloneCoding.NaverCafe.domain.bulletinBoard.BulletinBoard;
import CloneCoding.NaverCafe.domain.bulletinBoard.dto.RequestCreateGeneralBulletinBoard;
import CloneCoding.NaverCafe.domain.bulletinBoard.dto.ResponseGeneralCreateForm;
import CloneCoding.NaverCafe.domain.bulletinBoard.repository.BulletinBoardRepository;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.member.repository.MemberRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static CloneCoding.NaverCafe.message.SystemMessage.SUCCESSFULLY_REFLECT;

@Service
@RequiredArgsConstructor
public class BulletinBoardServiceImpl implements BulletinBoardService {

    private final BulletinBoardRepository bulletinBoardRepository;
    private final MemberRepository memberRepository;
    private final CafeRepository cafeRepository;
    private final CafeMemberRepository cafeMemberRepository;
    private final AesUtil aesUtil;

    @Override
    public ResponseGeneralCreateForm createGeneralForm(String token) {
        checkMember(token);
        return new ResponseGeneralCreateForm();
    }

    @Override
    public String createGeneralBulletinBoard(RequestCreateGeneralBulletinBoard request,
                                             String url, String token) {

        Cafe cafe = cafeRepository.findByUrl(url);
        checkCafeMember(cafe, token);

        BulletinBoard bulletinBoard = BulletinBoard.createGeneralBulletinBoard(cafe, request);

        bulletinBoardRepository.save(bulletinBoard);

        return SUCCESSFULLY_REFLECT.getMessage();

    }

    private void checkMember(String token) {
        String accountId = aesUtil.aesDecode(token);
        memberRepository.findByAccountId(accountId);
    }

    private void checkCafeMember(Cafe cafe, String token) {
        String accountId = aesUtil.aesDecode(token);
        cafeMemberRepository.findByAccountId(cafe, accountId);
    }

}
