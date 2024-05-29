package CloneCoding.NaverCafe.domain.menu.normal.integrate.service;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.member.repository.MemberRepository;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.Integrate;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.RequestCreateIntegrate;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.RequestUpdateIntegrate;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.ResponseCreateForm;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.ResponseUpdateForm;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.repository.IntegrateRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static CloneCoding.NaverCafe.domain.cafeMember.enums.CafeMemberPosition.changeNameToPosition;
import static CloneCoding.NaverCafe.message.SystemMessage.SUCCESSFULLY_REFLECT;

@Service
@RequiredArgsConstructor
public class IntegrateServiceImpl implements IntegrateService {

    private final IntegrateRepository integrateRepository;
    private final MemberRepository memberRepository;
    private final CafeRepository cafeRepository;
    private final CafeMemberRepository cafeMemberRepository;
    private final AesUtil aesUtil;

    @Override
    public ResponseCreateForm createIntegrateForm(String token) {
        checkMember(token);
        return new ResponseCreateForm();
    }

    @Override
    public String createIntegrate(RequestCreateIntegrate request,
                                  String url, String token) {

        Cafe cafe = cafeRepository.findByUrl(url);
        checkCafeMember(cafe, token);

        Integrate integrate = Integrate.createIntegrate(cafe, request);

        integrateRepository.save(integrate);

        return SUCCESSFULLY_REFLECT.getMessage();

    }

    @Override
    public ResponseUpdateForm createIntegrateUpdateForm(Long id, String token) {

        Integrate integrate = integrateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("게시판 정보를 찾을 수 없습니다."));

        Cafe cafe = cafeRepository.findById(integrate.getCafeId().getId())
                .orElseThrow(() -> new NoSuchElementException("카페 정보를 찾을 수 없습니다."));
        checkCafeMember(cafe, token);

        return ResponseUpdateForm.builder()
                .sequence(integrate.getSequence())
                .name(integrate.getName())
                .description(integrate.getDescription())
                .writeAuth(changeNameToPosition(integrate.getWriteAuth()))
                .readAuth(changeNameToPosition(integrate.getReadAuth()))
                .commentAuth(changeNameToPosition(integrate.getCommentAuth()))
                .useFavorite(integrate.isUseFavorite())
                .build();
    }

    @Override
    public String updateIntegrate(RequestUpdateIntegrate request,
                                  Long id, String token) {

        Integrate integrate = integrateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("게시판 정보를 찾을 수 없습니다."));

        Cafe cafe = cafeRepository.findById(integrate.getCafeId().getId())
                .orElseThrow(() -> new NoSuchElementException("카페 정보를 찾을 수 없습니다."));
        checkCafeMember(cafe, token);

        integrate.updateIntegrate(request);

        integrateRepository.save(integrate);

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
