package pl.millenium.onlinebookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.millenium.onlinebookstore.model.BookCategory;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "book_category", path = "book-category")
public interface CategoryRepository extends JpaRepository<BookCategory, Long> {
}
