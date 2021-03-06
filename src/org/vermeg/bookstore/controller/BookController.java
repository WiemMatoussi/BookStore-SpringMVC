package org.vermeg.bookstore.controller;

import java.util.List;

import  org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.service.BookService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")

public class BookController {
	
	@Autowired
	BookService bookService;
	
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Book> getBooks() {
		
		List<Book> listOfBooks = bookService.getAllBooks();
		
		return listOfBooks;
	}

	@RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Book getBookById(@PathVariable long id) {
		return bookService.getBook(id);
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addBook(@RequestBody Book book) {	
		bookService.addBook(book);
		return "redirect:/getAll";
	}

	@RequestMapping(value = "/updateBook/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateBook(@PathVariable("id") long id,Model model) {
		 model.addAttribute("book", this.bookService.getBook(id));
	        model.addAttribute("listOfBooks", this.bookService.getAllBooks());
	        return "bookDetails";
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteBook(@PathVariable("id") long id) {
		bookService.deleteBook(id);
		 return "redirect:/getAllBooks";

	}	
	
	
	
	@RequestMapping(value = "/totalprice", method = RequestMethod.POST, produces = "application/json")
	
	 public double TotalPriceListBook(@RequestBody List<Integer> book) {
		    double Total=0;
			for (int i=0;i<book.size(); i++){
				int idbook = book.get(i);
				Total= Total+bookService.getBook(idbook).getUnitPrice();
				
				
			}
			return Total;
		}
	
	
}
