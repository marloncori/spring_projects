package org.drmas.online_shop.implementations;

import org.drmas.online_shop.exception.ResourceNotFoundException;
import org.drmas.online_shop.models.Comment;
import org.drmas.online_shop.models.ErrMsg;
import org.drmas.online_shop.models.Product;
import org.drmas.online_shop.repositories.CommentDAO;
import org.drmas.online_shop.repositories.ProductDAO;
import org.drmas.online_shop.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ErrMsg errMsg;

    @Override
    public Comment addCommentToProduct(Comment comment, Long productId) {
        if(productId == null){
            throw new IllegalArgumentException(errMsg.getProductIdFail());
        }
        Optional<Product> product = productDAO.findById(productId);
        if(product.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getProductAbsent());
        }
        if(comment != null) {
            comment.setAddedAt(new Date());
        } else {
          throw new IllegalArgumentException(errMsg.getCommentMsgFail());
        }
        product.get().addCommentToProduct(comment);
        return commentDAO.save(comment);
    }

    @Override
    public Comment editComment(Comment comment, Long id) {
        if(comment == null){
            throw new IllegalArgumentException(errMsg.getCommentMsgFail());
        }
        if(id == null){
            throw new IllegalArgumentException(errMsg.getProductIdFail());
        }
        Optional<Comment> maybeComment = commentDAO.findById(id);
        if(maybeComment.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getCommentAbsent());
        }
            maybeComment.get().setTitle(comment.getTitle());
            maybeComment.get().setMessage(comment.getMessage());
            maybeComment.get().setAddedAt(new Date());
            maybeComment.get().setAddedBy(comment.getAddedBy());
        return commentDAO.save(maybeComment.get());
    }

    @Override
    public Comment findCommentById(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getCommentIdFail());
        }
        Optional<Comment> maybeComment = commentDAO.findById(id);
        if(maybeComment.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getCommentAbsent());
        }
        return maybeComment.get();
    }

    @Override
    public void deleteComment(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getCommentIdFail());
        }
        Optional<Comment> maybeComment = commentDAO.findById(id);
        if(maybeComment.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getCommentAbsent());
        }
        commentDAO.deleteById(maybeComment.get().getId());
    }

    @Override
    public List<Comment> findCommentsForProduct(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getCommentIdFail());
        }
        Optional<Product> maybeProduct = productDAO.findById(id);
        if(maybeProduct.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getProductAbsent());
        }
        return maybeProduct.get().getComments();
    }

    @Override
    public List<Comment> findAllComments() {
        Optional<List<Comment>> allComments =
                Optional.ofNullable(commentDAO.findAll());
        if(allComments.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getCommentAbsent());
        }
        return allComments.get();
    }
}
