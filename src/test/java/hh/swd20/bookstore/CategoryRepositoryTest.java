package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	@Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = repository.findByName("Hobby");
        
        assertThat(categories).hasSize(1);
    }
	
	@Test
    public void createNewCategoryk() {
    	Category category = new Category("History");
    	repository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    } 
	
	@Test
	@Transactional
	public void deleteCategoryByName() {
	    long deletedRecords = repository.deleteByName("Hobby");
	    assertThat(deletedRecords).isEqualTo(1);
	}

}
