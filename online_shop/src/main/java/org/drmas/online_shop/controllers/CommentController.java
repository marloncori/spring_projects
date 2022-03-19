package org.drmas.online_shop.controllers;

import org.drmas.online_shop.models.Comment;
import org.drmas.online_shop.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addCommentToProduct/{productId}")
    Comment addCommentToProduct(@RequestBody Comment comment,
                                @PathVariable Long productId){
        return commentService.addCommentToProduct(comment, productId);
    }

    @PutMapping("/editComment/{id}")
    Comment editComment(@RequestBody Comment comment,
                        @PathVariable Long id){
        return commentService.editComment(comment, id);
    }

    @GetMapping("/findCommentById/{commentId}")
    Comment findCommentById(@PathVariable Long commentId){
        return commentService.findCommentById(commentId);
    }

    @DeleteMapping("/deleteComment/{id}")
    void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }

    @GetMapping("/findCommentsForProduct/{productId}")
    List<Comment> findCommentsForProduct(@PathVariable Long productId){
        return commentService.findCommentsForProduct(productId);
    }

    @GetMapping("/findAllComents")
    List<Comment> findAllComments(){
        return commentService.findAllComments();
    }
}
