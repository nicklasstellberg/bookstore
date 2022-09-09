package hh.swd20.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;

@Controller
public class BookController {
		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public String getAutot(Model model) {
			List<Book> books = new ArrayList<Book>();
			books.add(new Book("Villahullu", "Heli Nikula", 2022, "9789523734319", 22.90));
			books.add(new Book("Sitan kalenteri 2022-2023", "Sita Salminen", 2022, "6430060036024", 21.90));
			model.addAttribute("books", books);
			
			return "booklist";
		}
}