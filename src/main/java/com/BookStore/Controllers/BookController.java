package com.BookStore.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.Beans.Book;
import com.BookStore.Services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/allbooks", method=RequestMethod.GET)
	public ResponseEntity<List<Book>> displayAllBooks() {
		List<Book> lstAllBooks = bookService.displayAllBooks();
		return new ResponseEntity<>(lstAllBooks,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addbook", method=RequestMethod.POST)
	public ResponseEntity<String> addBook(@RequestBody Book book){
		String message = bookService.addBook(book);
		return new ResponseEntity<>(message,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/order/{id}", method=RequestMethod.PUT)
	public ResponseEntity<String> orderBook(@PathVariable("id") int bookId) {
		bookService.orderBook(bookId);
		return new ResponseEntity<>("Book ordered successfully",HttpStatus.OK);
	}
	
		
	@RequestMapping(value="/deliveryStatus/{bookId}/{city}", method=RequestMethod.GET)
	public ResponseEntity<String> updateStatus(@PathVariable ("city") String city, @PathVariable("bookId") int bookid){
		bookService.updateStatus(city,bookid);
		return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		
	}
	

}
