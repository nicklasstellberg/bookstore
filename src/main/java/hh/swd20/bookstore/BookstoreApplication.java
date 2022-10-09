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
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner booktDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			Category category1 = new Category("Hobby");
			crepository.save(category1);
			Category category2 = new Category("Calendar");
			crepository.save(category2);
			Category category3 = new Category("Law");
			crepository.save(category3);
			repository.save(new Book("Villahullu", "Heli Nikula", 2022, "9789523734319", 22.90, category1));
			repository.save(new Book("Sitan kalenteri 2022-2023", "Sita Salminen", 2022, "6430060036024", 21.90, category2));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
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
