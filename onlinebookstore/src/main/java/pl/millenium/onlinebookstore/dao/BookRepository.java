package pl.millenium.onlinebookstore.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.millenium.onlinebookstore.model.Book;

@CrossOrigin("http://localhost:4200")
public interface BookRepository extends JpaRepository<Book, Long> {

    @RestResource(path = "categoryid")
    Page<Book> findByBookCategoryId(@Param("id") Long id, Pageable pageable);

    @RestResource(path = "keyword")
    Page<Book> findByNameContaining(@Param("name") String keyword, Pageable pageable) ;

}
