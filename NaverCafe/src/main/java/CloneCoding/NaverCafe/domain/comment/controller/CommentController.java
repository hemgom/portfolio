package CloneCoding.NaverCafe.domain.comment.controller;

import CloneCoding.NaverCafe.domain.comment.dto.RequestWriteComment;
import CloneCoding.NaverCafe.domain.comment.dto.ResponseReplyForm;
import CloneCoding.NaverCafe.domain.comment.dto.ResponseWriteForm;
import CloneCoding.NaverCafe.domain.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe/{cafe_url}")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/form")
    public ResponseWriteForm getCommentForm(@PathVariable("cafe_url") String url,
                                            @RequestHeader("Authorization") String token) {
        log.info("댓글 양식 요청");
        return commentService.createForm(url, token);
    }

    @PostMapping("/{normal_id}/comment")
    public String writeComment(@PathVariable("cafe_url") String url,
                               @PathVariable("normal_id") Long id,
                               @RequestBody @Valid RequestWriteComment request,
                               @RequestHeader("Authorization") String token) {
        log.info("댓글 작성 요청");
        return commentService.createComment(url, id, request, token);
    }

    @GetMapping("/comment/{comment_id}")
    public ResponseReplyForm getReplyForm(@PathVariable("cafe_url") String url,
                                          @PathVariable("comment_id") Long commentId,
                                          @RequestHeader("Authorization") String token) {
        log.info("답글 양식 요청");
        return commentService.createForm(url, commentId, token);
    }

    @PostMapping("/{normal_id}/comment/{comment_id}")
    public String writeReply(@PathVariable("cafe_url") String url,
                             @PathVariable("normal_id") Long articleId,
                             @PathVariable("comment_id") Long commentId,
                             @RequestBody @Valid RequestWriteComment request,
                             @RequestHeader("Authorization") String token) {
        log.info("답글 작성 요청");
        return commentService.createReply(url, articleId, commentId, request, token);
    }

}
