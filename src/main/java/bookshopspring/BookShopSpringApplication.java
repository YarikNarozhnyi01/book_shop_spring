package bookshopspring;

import bookshopspring.model.Book;
import bookshopspring.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookShopSpringApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookShopSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book book1 = new Book();
                book1.setAuthor("Steven King");
                book1.setTitle("It");
                book1.setIsbn("something");
                book1.setPrice(BigDecimal.valueOf(100));
                bookService.save(book1);
            }
        };
    }
}
