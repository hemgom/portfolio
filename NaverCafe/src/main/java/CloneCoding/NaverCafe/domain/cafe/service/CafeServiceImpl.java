package CloneCoding.NaverCafe.domain.cafe.service;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.dto.RequestCreateCafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.keyword.Keyword;
import CloneCoding.NaverCafe.domain.keyword.repository.KeywordRepository;
import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.repository.MemberRepository;
import CloneCoding.NaverCafe.message.SystemMessage;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;
    private final MemberRepository memberRepository;
    private final KeywordRepository keywordRepository;
    private final CafeMemberRepository cafeMemberRepository;
    private final AesUtil aesUtil;

    @Override
    public String createCafe(RequestCreateCafe request, String token) {

        Cafe madeCafe = Cafe.createCafe(request.getCafeInfo());

        String accountId = aesUtil.aesDecode(token);
        Member findMember = memberRepository.findByAccountId(accountId);

        List<Keyword> keywords = new ArrayList<>();

        if (!request.getKeywords().isEmpty()) {
            keywords = Keyword.createKeywords(request.getKeywords(), madeCafe);
        }

        CafeMember cafeManager = CafeMember.addCafeManager(
                findMember.getAccountId(), findMember.getNickname(),
                findMember.getGender(), findMember.getBirthday(), madeCafe);

        cafeRepository.save(madeCafe);
        keywordRepository.saveAll(keywords);
        cafeMemberRepository.save(cafeManager);

        return SystemMessage.CREATE_CAFE_COMPLETE.getMessage();

    }

}
