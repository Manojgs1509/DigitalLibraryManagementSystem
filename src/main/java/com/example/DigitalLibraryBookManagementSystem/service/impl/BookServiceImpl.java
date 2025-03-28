package com.example.DigitalLibraryBookManagementSystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DigitalLibraryBookManagementSystem.dao.BookDAO;
import com.example.DigitalLibraryBookManagementSystem.exception.BookNotFoundException;
import com.example.DigitalLibraryBookManagementSystem.pojo.Book;
import com.example.DigitalLibraryBookManagementSystem.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	   private BookDAO bookDAO;
	   
	   public BookServiceImpl( BookDAO bookDAO) {
		   this.bookDAO=bookDAO;
	   }

	    @Override
	    public void addBook(Book book) {
	    	bookDAO.addBook(book);
	    }

	    @Override
	    public List<Book> getAllBooks() {
	        return bookDAO.getAllBooks();
	    }

	    @Override
	    public Book getBookById(Long id) {
	        return bookDAO.getBookById(id)
	                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
	    }

	    @Override
	    public void updateBook(Long id, Book book) {
	        getBookById(id); // Ensure the book exists before updating
	        bookDAO.updateBook(id, book);
	    }

	    @Override
	    public void deleteBook(Long id) {
	        getBookById(id); // Ensure the book exists before deleting
	        bookDAO.deleteBook(id);
	    }

}
