package springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.spring5webapp.domain.Author;
import springframework.spring5webapp.domain.Book;
import springframework.spring5webapp.domain.Publisher;
import springframework.spring5webapp.repositories.AuthorRepository;
import springframework.spring5webapp.repositories.BookRepository;
import springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher1 = new Publisher();
        publisher1.setName("Swan");
        publisher1.setAddressLine1("Fairmount");
        publisher1.setCity("Jersey City");
        publisher1.setState("NJ");
        publisher1.setZip("07306");

        publisherRepository.save(publisher1);

        System.out.println("Publisher details: \nName = "+ publisher1.getName() + "\nAddress = "+ publisher1.getAddressLine1());

        Author shalwak = new Author("Shalwak", "Dangore");
        Book book1 = new Book("Mystery of jade" , "1");

        shalwak.getBooks().add(book1);
        book1.getAuthors().add(shalwak);
        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);

        authorRepository.save(shalwak);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);

        Author shreya = new Author("Shreya", "Agrawal");
        Book book2 = new Book("History of India","2");

        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book2);
        authorRepository.save(shreya);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Books by Publisher "+publisher1.getName() + " : " +publisher1.getBooks().size());
    }
}
