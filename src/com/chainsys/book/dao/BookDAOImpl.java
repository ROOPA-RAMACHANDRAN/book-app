package com.chainsys.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.sql.Date;

import com.chainsys.book.model.Book;


public class BookDAOImpl implements BookDAO{
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	public BookDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:EBS1228", "apps", "apps");
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
		return null;
	}
	
}
