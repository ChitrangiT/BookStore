package com.BookStore.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.Beans.Book;
import com.BookStore.Services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("order/{id}")
	public String orderBook(@PathVariable("id") int bookId) {
		bookService.orderBook(bookId);
		return "Book ordered successfully";
	}
	
	@RequestMapping("allbooks")
	public List<Book> displayAllBooks() {
		List<Book> lstAllBooks = bookService.displayAllBooks();
		return lstAllBooks;
	}
	

}
