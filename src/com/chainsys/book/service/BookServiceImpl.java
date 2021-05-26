package com.chainsys.book.service;

import java.util.Set;


import com.chainsys.book.dao.BookDAO;
import com.chainsys.book.dao.BookDAOImpl;
import com.chainsys.book.model.Book;


public class BookServiceImpl implements BookService{
	private static BookDAO dao;

	public BookServiceImpl() {
		dao = new BookDAOImpl();
	}


	@Override
	public void save(Book Book) {
		// TODO Auto-generated method stub
		dao.save(Book);
		
	}



	@Override
	public Set<Book> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
