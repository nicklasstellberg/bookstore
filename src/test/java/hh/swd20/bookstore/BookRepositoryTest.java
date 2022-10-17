package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Villahullu");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Heli Nikula");
    }
	
	@Test
    public void createNewBook() {
    	Book book = new Book("Mihin menet Suomi?", "Mika Aaltola", 2022, "9789520447908", 22.90, null);
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    } 
	
	@Test
	@Transactional
	public void deleteBookByTitle() {
	    long deletedRecords = repository.deleteByTitle("Villahullu");
	    assertThat(deletedRecords).isEqualTo(1);
	}

}
