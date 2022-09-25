package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner booktDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			Category category1 = new Category("Hobby");
			crepository.save(category1);
			Category category2 = new Category("Calendar");
			crepository.save(category2);
			Category category3 = new Category("Law");
			crepository.save(category3);
			repository.save(new Book("Villahullu", "Heli Nikula", 2022, "9789523734319", 22.90, category1));
			repository.save(new Book("Sitan kalenteri 2022-2023", "Sita Salminen", 2022, "6430060036024", 21.90, category2));
			log.info("Saved some sample categories");
			log.info("Saved some sample books");
			log.info("Fetch all categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
