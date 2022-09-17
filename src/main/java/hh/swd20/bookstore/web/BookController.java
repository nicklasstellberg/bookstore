package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository; 
	@RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
}