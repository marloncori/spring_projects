package pl.tutorial.restapi.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.tutorial.restapi.error.PostNotFoundException;
import pl.tutorial.restapi.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("Select p From Post p")
    List<Post> findAllPosts(Pageable page);

    Post findByTitle(String title) throws PostNotFoundException;

}
