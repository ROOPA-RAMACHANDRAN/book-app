package com.chainsys.book.service;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;


public interface BookService {
	
	void save(Book Book) ;

	Set<Book> findAll();

	void update(Book Book) throws BookNotFoundException;

    void delete(int id) throws BookNotFoundException;

	List<String> findAllName();

	List<Integer> findAllId();

	List<Date> findAllDate();

	Book findById(int id) throws BookNotFoundException;

	Book findByDate(LocalDate date) throws BookNotFoundException;

	Book findByName(String name) throws BookNotFoundException;

	void delete_name(String name)throws BookNotFoundException;

	

	

}
