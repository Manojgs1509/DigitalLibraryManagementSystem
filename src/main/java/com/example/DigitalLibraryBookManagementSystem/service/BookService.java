package com.example.DigitalLibraryBookManagementSystem.service;

import java.util.List;

import com.example.DigitalLibraryBookManagementSystem.pojo.Book;

public interface BookService {

	 void addBook(Book book);
	    List<Book> getAllBooks();
	    Book getBookById(Long id);
	    void updateBook(Long id, Book book);
	    void deleteBook(Long id);
}
