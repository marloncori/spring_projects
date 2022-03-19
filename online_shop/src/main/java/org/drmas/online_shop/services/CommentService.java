package org.drmas.online_shop.services;

import org.drmas.online_shop.models.Comment;

import java.util.List;

public interface CommentService {

    Comment addCommentToProduct(Comment comment, Long idProduct);
    Comment editComment(Comment comment, Long id);
    Comment findCommentById(Long id);
    void deleteComment(Long id);
    List<Comment> findCommentsForProduct(Long idProduct);
    List<Comment> findAllComments();
}
