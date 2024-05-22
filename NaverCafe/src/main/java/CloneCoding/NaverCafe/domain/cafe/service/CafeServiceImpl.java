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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static CloneCoding.NaverCafe.message.SystemMessage.*;

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

        Cafe cafe = Cafe.createCafe(request.getCafeInfo());

        String accountId = aesUtil.aesDecode(token);
        Member findMember = memberRepository.findByAccountId(accountId);

        List<Keyword> keywords = createKeywords(request.getKeywords(), cafe);

        CafeMember cafeManager = CafeMember.createCafeManager(
                findMember.getAccountId(), findMember.getNickname(),
                findMember.getGender(), findMember.getBirthday(), cafe
        );

        cafeRepository.save(cafe);
        keywordRepository.saveAll(keywords);
        cafeMemberRepository.save(cafeManager);

        return CREATE_CAFE_COMPLETE.getMessage();

    }

    private List<Keyword> createKeywords(List<String> keywords, Cafe cafe) {
        List<Keyword> result = new ArrayList<>();

        if (!keywords.isEmpty()) {
            result = Keyword.createKeywords(keywords, cafe);
        }

        return result;
    }

}
