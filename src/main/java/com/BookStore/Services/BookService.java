package com.BookStore.Services;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.BookStore.Beans.Book;
import com.BookStore.Dao.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	@Autowired
	JmsMessagingTemplate jmstemplate;
	
	@Autowired
	Queue msgqueue;
	
	
	public Book getBookById(int bookId) {
		Book book = bookRepo.findById(bookId).orElse(null);
		return book;
	}

	public void orderBook(int bookId) {
		Book purchasedBook = getBookById(bookId);
		purchasedBook.setNoOfCopies(purchasedBook.getNoOfCopies()-1);	
		bookRepo.save(purchasedBook);
	}

	public List<Book> displayAllBooks() {
		List<Book> lstAllBooks = (List<Book>) bookRepo.findAll();
		return lstAllBooks;
	}

	public void updateStatus(String city, int bookid) {
		String message = "Order with bookid " + bookid +" reached city "+ city;
		jmstemplate.convertAndSend(msgqueue,message);
		
	}

	public String addBook(Book book) {
		bookRepo.save(book);
		return "Added Successfully";
	}

	

}
