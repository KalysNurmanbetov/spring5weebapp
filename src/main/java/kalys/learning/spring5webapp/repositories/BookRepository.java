package kalys.learning.spring5webapp.repositories;

import kalys.learning.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
