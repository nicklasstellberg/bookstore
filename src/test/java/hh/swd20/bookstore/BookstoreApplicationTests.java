package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.web.BookController;
import hh.swd20.bookstore.web.CategoryController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;
	
	@Autowired
	private CategoryController categoryController;

	@Test
	public void contextLoads() {
		assertThat(bookController).isNotNull();
	}
	
	@Test
	public void contextLoads2() {
		assertThat(categoryController).isNotNull();
	}

}
