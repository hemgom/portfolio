package CloneCoding.NaverCafe.domain.comment.service;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import CloneCoding.NaverCafe.domain.article.normal.repository.NormalRepository;
import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import CloneCoding.NaverCafe.domain.cafeMember.CafeMember;
import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import CloneCoding.NaverCafe.domain.comment.Comment;
import CloneCoding.NaverCafe.domain.comment.dto.*;
import CloneCoding.NaverCafe.domain.comment.repository.CommentRepository;
import CloneCoding.NaverCafe.security.AesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static CloneCoding.NaverCafe.message.SystemMessage.*;

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

        article.addGroupNum();
        article.addCommentCount();

        Comment comment = Comment.create(user, article.getId(), article.getGroupNum(), request);

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
        Comment targetComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("댓글 정보를 찾을 수 없습니다."));

        Comment reply = Comment.createReply(user, article.getId(), targetComment.getCommentGroup(),
                targetComment.getAccountId(), targetComment.getNickname(), request);

        article.addCommentCount();

        commentRepository.save(reply);
        normalRepository.save(article);

        return WRITE_COMMENT_COMPLETE.getMessage();
    }

    @Override
    public ResponseReadComments createCommentList(String cafeUrl, Long articleId, String token) {

        checkCafeMember(cafeUrl, token);
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        List<ResponseReadComment> result = new ArrayList<>();

        for (Comment c : comments) {
            result.add(ResponseReadComment.builder()
                    .profileImage(c.getProfileImage())
                    .nickname(c.getNickname())
                    .accountId(c.getAccountId())
                    .targetAccountId(c.getTargetAccountId())
                    .targetNickname(c.getTargetNickname())
                    .body(c.getBody())
                    .updateAt(c.getUpdateAt())
                    .build());
        }

        return new ResponseReadComments(result);
    }

    @Override
    public String updateComment(String cafeUrl, Long commentId, RequestWriteComment request,
                                String token) {

        checkCafeMember(cafeUrl, token);
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("댓글 정보를 찾을 수 없습니다."));

        comment.update(request.getBody(), LocalDateTime.now());

        commentRepository.save(comment);

        return UPDATE_COMMENT_COMPLETE.getMessage();
    }

    @Transactional
    @Override
    public String delComment(String cafeUrl, Long normalId, Long commentId, String token) {

        checkCafeMember(cafeUrl, token);
        Normal article = normalRepository.findByIdWithLock(normalId)
                .orElseThrow(() -> new NoSuchElementException("게시글 정보를 찾을 수 없습니다."));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("댓글 정보를 찾을 수 없습니다."));

        article.subCommentCount();

        commentRepository.delete(comment);
        normalRepository.save(article);

        return DELETE_COMMENT_COMPLETE.getMessage();
    }

    private CafeMember checkCafeMember(String url, String token) {

        String accountId = aesUtil.aesDecode(token);
        Cafe findCafe = cafeRepository.findByUrl(url);

        return cafeMemberRepository.findByAccountId(findCafe, accountId);
    }

}
