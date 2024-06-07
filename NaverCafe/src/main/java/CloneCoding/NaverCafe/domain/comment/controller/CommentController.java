package CloneCoding.NaverCafe.domain.comment.controller;

import CloneCoding.NaverCafe.domain.comment.dto.RequestWriteComment;
import CloneCoding.NaverCafe.domain.comment.dto.ResponseWriteForm;
import CloneCoding.NaverCafe.domain.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe/{cafe_url}/{normal_id}")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/form")
    public ResponseWriteForm getCommentForm(@PathVariable("cafe_url") String url,
                                            @PathVariable("normal_id") Long id,
                                            @RequestHeader("Authorization") String token) {
        log.info("댓글 양식 요청");
        return commentService.createForm(url, id, token);
    }

    @PostMapping("/comment")
    public String writeComment(@PathVariable("cafe_url") String url,
                               @PathVariable("normal_id") Long id,
                               @RequestBody @Valid RequestWriteComment request,
                               @RequestHeader("Authorization") String token) {
        log.info("댓글 작성 요청");
        return commentService.createComment(url, id, request, token);
    }

}
