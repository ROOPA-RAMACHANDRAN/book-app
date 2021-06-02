package com.chainsys.book.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;



import com.chainsys.book.dao.BookDAO;
import com.chainsys.book.dao.BookDAOImpl;
import com.chainsys.book.exception.BookNotFoundException;
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
	public void update(Book Book) throws BookNotFoundException {
		Book result = dao.findById(Book.getId());
		if (result == null) {
			throw new BookNotFoundException("Book Id Not Found");
		} else {
			dao.update(Book);
		}

	}
	
	
	@Override
	public void delete(int id) throws BookNotFoundException {
		Book Book = dao.findById(id);
		if (Book == null) {
			throw new BookNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(id);
		}
	}



	@Override
	public Set<Book> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}


	@Override
	public List<String> findAllName() {
		// TODO Auto-generated method stub
		return dao.findAllName();
	}


	@Override
	public List<Integer> findAllId() {
		// TODO Auto-generated method stub
		return dao.findAllId();
	}


	@Override
	public List<LocalDate> findAllDate() {
		// TODO Auto-generated method stub
		return dao.findAllDate();
	}
	

	
	@Override
	public Book findById(int id) throws  BookNotFoundException {
		Book Book = dao.findById(id);
		if (Book == null) {
			throw new BookNotFoundException("Book Id Not Found");
		} else {
			return Book;
		}
	}


	@Override
	public Book findByName(String name) throws BookNotFoundException {
		 Book  Book = dao.findByName(name);
		if ( Book == null) {
			throw new  BookNotFoundException("Book Name Not Found");
		} else {
			return  Book;
		}
	}
	@Override
	public Book findByDate(LocalDate date) throws BookNotFoundException {
		Book book=dao.findByDate(date);
		if (book == null) {
			throw new BookNotFoundException("Publish date Not Found");
		} else {
			return book;
		}
	
	}

	

}
