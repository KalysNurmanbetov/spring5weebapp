package kalys.learning.spring5webapp.repositories;

import kalys.learning.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
