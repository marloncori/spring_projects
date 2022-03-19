package org.drmas.online_shop.repositories;

import org.drmas.online_shop.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<Comment, Long> {

}
