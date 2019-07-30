package com.BookStore.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.Beans.Book;
import com.BookStore.Dao.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	
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

}
