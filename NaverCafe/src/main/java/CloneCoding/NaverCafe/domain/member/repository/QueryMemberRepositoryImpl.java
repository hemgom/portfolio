package CloneCoding.NaverCafe.domain.member.repository;

import CloneCoding.NaverCafe.domain.member.Member;
import CloneCoding.NaverCafe.domain.member.dto.RequestUpdateAccountPassword;
import CloneCoding.NaverCafe.domain.member.dto.RequestJoinMember;
import CloneCoding.NaverCafe.domain.member.dto.RequestLogin;
import CloneCoding.NaverCafe.domain.member.dto.RequestUpdateMember;
import CloneCoding.NaverCafe.domain.member.dto.ResponseMemberInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import static CloneCoding.NaverCafe.domain.member.QMember.*;
import static CloneCoding.NaverCafe.security.LoginStatus.*;

@Repository
@RequiredArgsConstructor
public class QueryMemberRepositoryImpl implements QueryMemberRepository {

    private final JPAQueryFactory query;

    @Override
    public Member join(RequestJoinMember request) {
        LocalDate birth = LocalDate.of(request.getYear(), request.getMonth(), request.getDay());

        return Member.builder()
                .accountId(request.getAccountId())
                .accountPassword(request.getAccountPassword())
                .email(request.getEmail())
                .username(request.getUsername())
                .birthday(birth)
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .nickname(request.getNickname())
                .build();
    }

    @Override
    public ResponseMemberInfo makeResponseMemberInfo(Member member) {
        return ResponseMemberInfo.builder()
                .accountId(member.getAccountId())
                .email(member.getEmail())
                .username(member.getUsername())
                .birthday(member.getBirthday())
                .phoneNumber(member.getPhoneNumber())
                .nickname(member.getNickname())
                .build();
    }

    @Override
    public Member findByAccount(RequestLogin request) {
        return Optional.ofNullable(query
                        .selectFrom(member)
                        .where(member.accountId.eq(request.getAccountId()), member.accountPassword.eq(request.getAccountPassword()))
                        .fetchOne())
                .orElseThrow(() -> new NoSuchElementException("아이디 또는 비밀번호가 올바르지 않습니다."));
    }

    @Override
    public Member findByAccountId(String accountId) {
        return Optional.ofNullable(query
                        .selectFrom(member)
                        .where(member.accountId.eq(accountId))
                        .fetchOne())
                .orElseThrow(() -> new NoSuchElementException("유효하지 않은 접근입니다."));
    }

    @Override
    public boolean checkLogin(Member member) {
        return !member.getStatus().equals(STATUS_LOGIN.getStatus());
    }

    @Override
    public Member updateMemberInfo(Member member, RequestUpdateMember request) {
        member.updateInfo(request);
        return member;
    }

    @Override
    public boolean checkAccountPassword(Member member, RequestUpdateAccountPassword request) {

        if (!member.getAccountPassword().equals(request.getNowAccountPassword())) return false;

        return request.getChangeAccountPassword().equals(request.getCheckChangeAccountPassword());

    }

    @Override
    public Member updateAccountPassword(Member member, String changeAccountPassword) {
        member.updateAccountPassword(changeAccountPassword);
        return member;
    }

}