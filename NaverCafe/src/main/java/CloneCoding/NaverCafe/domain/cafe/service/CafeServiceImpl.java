package CloneCoding.NaverCafe.domain.cafe.service;

import CloneCoding.NaverCafe.domain.menu.normal.integrate.Integrate;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.repository.IntegrateRepository;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.dto.RequestCreateCafe;
import CloneCoding.NaverCafe.domain.cafe.dto.ResponseCreateForm;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.keyword.Keyword;
import CloneCoding.NaverCafe.domain.keyword.repository.KeywordRepository;
import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.repository.MemberRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static CloneCoding.NaverCafe.message.SystemMessage.CREATE_CAFE_COMPLETE;

@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;
    private final MemberRepository memberRepository;
    private final KeywordRepository keywordRepository;
    private final CafeMemberRepository cafeMemberRepository;
    private final IntegrateRepository integrateRepository;
    private final AesUtil aesUtil;

    @Override
    public ResponseCreateForm createForm(String token) {
        checkMember(token);
        return new ResponseCreateForm();
    }

    @Override
    public String createCafe(RequestCreateCafe request, String token) {

        Cafe cafe = Cafe.createCafe(request.getCafeInfo());

        Member member = checkMember(token);

        List<Keyword> keywords = createKeywords(request.getKeywords(), cafe);

        CafeMember cafeManager = CafeMember.createCafeManager(
                member.getAccountId(), member.getNickname(),
                member.getGender(), member.getBirthday(), cafe
        );

        Integrate basicIntegrate = Integrate.createDefaultIntegrate(cafe);

        cafeRepository.save(cafe);
        keywordRepository.saveAll(keywords);
        cafeMemberRepository.save(cafeManager);
        integrateRepository.save(basicIntegrate);

        return CREATE_CAFE_COMPLETE.getMessage();

    }

    private Member checkMember(String token) {
        String accountId = aesUtil.aesDecode(token);
        return memberRepository.findByAccountId(accountId);
    }

    private List<Keyword> createKeywords(List<String> keywords, Cafe cafe) {
        List<Keyword> result = new ArrayList<>();

        if (!keywords.isEmpty()) {
            result = Keyword.createKeywords(keywords, cafe);
        }

        return result;
    }

}
