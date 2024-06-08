package CloneCoding.NaverCafe.domain.comment.service;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import CloneCoding.NaverCafe.domain.article.normal.repository.NormalRepository;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.comment.Comment;
import CloneCoding.NaverCafe.domain.comment.dto.RequestWriteComment;
import CloneCoding.NaverCafe.domain.comment.dto.ResponseReplyForm;
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
    public ResponseWriteForm createForm(String url, String token) {

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

    @Override
    public ResponseReplyForm createForm(String url, Long commentId, String token) {

        CafeMember user = checkCafeMember(url, token);
        Comment replyTarget = commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("댓글 정보를 찾을 수 없습니다."));

        return ResponseReplyForm.builder()
                .nickname(user.getNickname())
                .targetNickname(replyTarget.getNickname())
                .build();
    }

    @Transactional
    @Override
    public String createReply(String url, Long normalId, Long commentId,
                              RequestWriteComment request, String token) {

        CafeMember user = checkCafeMember(url, token);
        Normal article = normalRepository.findByIdWithLock(normalId)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보를 찾을 수 없습니다."));

        Comment reply = Comment.create(user, article.getId(), request);

        Comment replyTarget = commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("댓글 정보를 찾을 수 없습니다."));

        reply.setMainId(checkReplyMain(replyTarget));
        reply.setTargetId(replyTarget.getId());

        article.addCommentCount();

        commentRepository.save(reply);
        normalRepository.save(article);

        return WRITE_COMMENT_COMPLETE.getMessage();
    }

    private CafeMember checkCafeMember(String url, String token) {

        String accountId = aesUtil.aesDecode(token);
        Cafe findCafe = cafeRepository.findByUrl(url);

        return cafeMemberRepository.findByAccountId(findCafe, accountId);
    }

    private Long checkReplyMain(Comment replyTarget) {

        Long replyMainId = 0L;

        if (replyTarget.getReplyMain() == 0L) {
            replyMainId = replyTarget.getId();
        } else {
            replyMainId = replyTarget.getReplyMain();
        }

        return replyMainId;
    }

}
