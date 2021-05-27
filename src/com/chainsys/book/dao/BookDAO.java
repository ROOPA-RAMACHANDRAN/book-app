package com.chainsys.book.dao;

import java.util.Set;

import com.chainsys.book.model.Book;

public interface BookDAO {
	void save(Book book);

	Set<Book> findAll();

	Book findById(int id);

	void update(Book book);


}
