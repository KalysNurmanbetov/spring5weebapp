package kalys.learning.spring5webapp.bootstrap;

import kalys.learning.spring5webapp.model.Author;
import kalys.learning.spring5webapp.model.Book;
import kalys.learning.spring5webapp.repositories.AuthorRepository;
import kalys.learning.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.init();
    }

    private void init(){
        Author rod = new Author("Rod", "Johnson");
        Book noejb = new Book("No EJB");
        rod.getBooks().add(noejb);
        noejb.getAuthors().add(rod);
        this.authorRepository.save(rod);
        this.bookRepository.save(noejb);

        Author en = new Author("Evans","Nord");
        Book ddd = new Book("Domain Design Development");
        en.getBooks().add(ddd);
        ddd.getAuthors().add(en);
        this.authorRepository.save(en);
        this.bookRepository.save(ddd);
    }
}
