package com.chainsys.book.dao;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.chainsys.book.model.Book;

public interface BookDAO {
	
	void save(Book book);

	Set<Book> findAll();

	Book findById(int id);

	void update(Book book);

	void delete(int id);

	List<Integer> findAllId();

	List<Date> findAllDate();

	List<String> findAllName();

	Book findByName(String name);

	Book findByDate(LocalDate date);

	void delete_name(String name);

	




}
