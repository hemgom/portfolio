package CloneCoding.NaverCafe.domain.comment.service;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import CloneCoding.NaverCafe.domain.article.normal.repository.NormalRepository;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.comment.Comment;
import CloneCoding.NaverCafe.domain.comment.dto.RequestWriteComment;
import CloneCoding.NaverCafe.domain.comment.dto.ResponseWriteForm;
import CloneCoding.NaverCafe.domain.comment.repository.CommentRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static CloneCoding.NaverCafe.message.SystemMessage.WRITE_COMMENT_COMPLETE;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CafeRepository cafeRepository;
    private final CafeMemberRepository cafeMemberRepository;
    private final NormalRepository normalRepository;
    private final AesUtil aesUtil;

    @Override
    public ResponseWriteForm createForm(String url, Long id, String token) {

        CafeMember user = checkCafeMember(url, token);

        return ResponseWriteForm.builder()
                .nickname(user.getNickname())
                .build();
    }

    @Transactional
    @Override
    public String createComment(String url, Long id, RequestWriteComment request, String token) {

        CafeMember user = checkCafeMember(url, token);
        Normal article = normalRepository.findByIdWithLock(id)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보를 찾을 수 없습니다."));

        Comment comment = Comment.create(user, article.getId(), request);
        article.addCommentCount();

        commentRepository.save(comment);
        normalRepository.save(article);

        return WRITE_COMMENT_COMPLETE.getMessage();
    }

    private CafeMember checkCafeMember(String url, String token) {
        String accountId = aesUtil.aesDecode(token);
        Cafe findCafe = cafeRepository.findByUrl(url);
        return cafeMemberRepository.findByAccountId(findCafe, accountId);
    }

}
