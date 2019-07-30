package com.BookStore.Dao;
import org.springframework.data.repository.CrudRepository;

import com.BookStore.Beans.Book;

public interface BookRepo extends CrudRepository<Book,Integer>{

}
