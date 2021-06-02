package com.chainsys.book.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;


public class BookDAOImpl implements BookDAO{
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Book> bookSet;
	private static ArrayList<String> namelist;
	private static ArrayList<Integer> idlist;
	private static ArrayList<LocalDate> datelist;
	
	public BookDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:DBEBS12", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void save(Book book) {
		try {
			pstmt = con.prepareStatement("insert into book_2590 values(?,?,?)");
			pstmt.setInt(1, book.getId());
			pstmt.setString(2, book.getName());
			pstmt.setDate(3, Date.valueOf(book.getPublish_date()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	public Set<Book> findAll() {
		// TODO Auto-generated method stub
		try {
			pstmt = con.prepareStatement("select * from book_2590");
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				Book book = new Book(rs.getInt("id"), rs.getString("name"),
						rs.getDate("publish_date").toLocalDate());
				bookSet.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}
	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		Book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2590 where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDate("publish_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	
	@Override
	public void delete(int id) {
		try {
			pstmt = con.prepareStatement("delete book_2590 where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		try {
			pstmt = con.prepareStatement("update book_2590 set name=? where id=?");
			pstmt.setString(1, book.getName());
			pstmt.setInt(2, book.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<String> findAllName() {
		try {
			pstmt = con.prepareStatement("select name from book_2590");
			rs = pstmt.executeQuery();
			 namelist = new ArrayList<>();
			while (rs.next()) {
				namelist.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return namelist;
	}
	@Override
	public List<Integer> findAllId() {
		try {
			pstmt = con.prepareStatement("select id from book_2590");
			rs = pstmt.executeQuery();
			 idlist = new ArrayList<>();
			while (rs.next()) {
				idlist.add(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idlist;
	}
	@Override
	public List<LocalDate> findAllDate(){
		try {
			pstmt = con.prepareStatement("select publish_date from book_2590");
			rs = pstmt.executeQuery();
			 datelist = new ArrayList<>();
			while (rs.next()) {
				datelist.add(rs.getDate("publish_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datelist;
	}
	
	@Override
	public Book findByName(String name) {
		Book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2590 where name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDate("publish_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public Book findByDate(LocalDate date){
		Book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2590 where publish_date=?");
			pstmt.setDate(1, Date.valueOf(date));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDate("publish_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;

	}
		
	}

