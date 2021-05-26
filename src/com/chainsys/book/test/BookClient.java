package com.chainsys.book.test;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;


public class BookClient {
	public static void main(String[] args){
		Set<Book>bookSet;
		BookService service=new BookServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		String name;
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Adding a Book");
			date = "03/06/2002";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Book newBook = new Book(7, "Life of Pi", LocalDate.parse(date, dateFormat));
			service.save(newBook);
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;
		
	}

}
}