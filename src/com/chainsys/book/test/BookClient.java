package com.chainsys.book.test;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;

public class BookClient {
	public static void main(String[] args){
		Set<Book>bookSet;
		List<String> namelist;
		List<Integer> idlist;
		List<Date> datelist;
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
			Book newBook = new Book(6, "Now you see me", LocalDate.parse(date, dateFormat));
			service.save(newBook);
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;
		case 2:
			System.out.println("Update the Book Name Based on the Id");
			date = "03/06/2002";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Book updateBook = new Book(6, "Now you see me", LocalDate.parse(date, dateFormat));
			try {
				service.update(updateBook);
				bookSet = service.findAll();
				System.out.println(bookSet);
			} catch (BookNotFoundException e) {

			}
			break;
		case 3:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				service.delete(id);
				bookSet = service.findAll();
				System.out.println(bookSet);
			} catch (BookNotFoundException e) {
			}
			break;
		case 4:
			System.out.println("Find All book Names");
			namelist = service.findAllName();
			System.out.println(namelist);
			break;
		case 5:
			System.out.println("Find All ID of the book");
			idlist = service. findAllId();
			System.out.println(idlist);
			break;
		case 6:
			System.out.println("Find All Publish date of the book");
			datelist = service. findAllDate();
			System.out.println(datelist);
			break;

			
		
	}

}
}