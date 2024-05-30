package CloneCoding.NaverCafe.domain.article.normal.service;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import CloneCoding.NaverCafe.domain.article.normal.dto.RequestWriteNormal;
import CloneCoding.NaverCafe.domain.article.normal.dto.ResponseWriteFormNormal;
import CloneCoding.NaverCafe.domain.article.normal.repository.NormalRepository;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static CloneCoding.NaverCafe.message.SystemMessage.WRITE_COMPLETE;

@Service
@RequiredArgsConstructor
public class NormalServiceImpl implements NormalService {

    private final NormalRepository normalRepository;
    private final CafeRepository cafeRepository;
    private final CafeMemberRepository cafeMemberRepository;
    private final AesUtil aesUtil;

    @Override
    public ResponseWriteFormNormal createWriteForm(String url, String token) {
        checkAuth(url, token);
        return new ResponseWriteFormNormal();
    }

    @Override
    public String createNormal(RequestWriteNormal request, String url, String token) {

        CafeMember cafeMember = checkAuth(url, token);

        Normal normal = Normal.create(request, cafeMember);

        normalRepository.save(normal);

        return WRITE_COMPLETE.getMessage();

    }

    private CafeMember checkAuth(String url, String token) {
        Cafe cafe = cafeRepository.findByUrl(url);
        String accountId = aesUtil.aesDecode(token);

        return cafeMemberRepository.findByAccountId(cafe, accountId);
    }

}
