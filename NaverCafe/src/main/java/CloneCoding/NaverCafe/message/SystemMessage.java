package CloneCoding.NaverCafe.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SystemMessage {

    JOIN_COMPLETE_NAVER("정상적으로 회원가입을 완료했습니다!" +
            System.lineSeparator() +
            "로그인 페이지로 이동해 로그인 해주세요."),

    LOGIN_COMPLETE("정상적으로 로그인이 완료되었습니다!"),

    PLEASE_CHECK_LOGIN("로그인이 필요한 서비스입니다."),

    LOGOUT_COMPLETE("정상적으로 로그아웃이 완료되었습니다!"),

    CHANGE_ACCOUNT_PASSWORD_FAILED("현재 비밀번호 또는 바꿀 비밀번호를 잘못 입력하였습니다."),

    CHANGE_ACCOUNT_PASSWORD_COMPLETE("비밀번호 변경이 완료되었습니다!" +
            System.lineSeparator() +
            "변경된 비밀번호로 다시 로그인 해주세요."),

    SECEDE_MEMBER_COMPLETE("회원 탈퇴가 완료되었습니다."),

    CREATE_CAFE_COMPLETE("카페 생성이 완료되었습니다."),

    JOIN_COMPLETE_CAFE("정상적으로 가입을 완료했습니다!"),

    UPDATE_CAFE_MEMBER_INFO("카페 회원 정보 수정이 완료되었습니다."),

    NICKNAME_NOT_UNIQUE("중복된 별명입니다. 다른 별명을 입력하세요."),

    DELETE_CAFE_MEMBER_COMPLETE("카페 탈퇴를 완료하였습니다."),

    SUCCESSFULLY_REFLECT("성공적으로 반영되었습니다."),

    WRITE_COMPLETE("게시글 등록이 완료되었습니다."),

    DELETE_ARTICLE_COMPLETE("게시글 삭제가 완료 되었습니다."),

    ADD_FAVORITE_COMPLETE("게시글을 좋아요로 등록했습니다."),

    SUB_FAVORITE_COMPLETE("게시글 좋아요를 취소했습니다."),

    WRITE_COMMENT_COMPLETE("댓글 작성을 완료하였습니다."),

    UPDATE_COMMENT_COMPLETE("댓글 수정을 완료하였습니다."),
    ;

    private final String message;

}