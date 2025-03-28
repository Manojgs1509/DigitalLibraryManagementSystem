package com.example.DigitalLibraryBookManagementSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DigitalLibraryBookManagementSystem.pojo.Book;
import com.example.DigitalLibraryBookManagementSystem.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	
	
	 
	 
	 @PostMapping
	    public ResponseEntity<String> addBook(@RequestBody Book book) {
	        bookService.addBook(book);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully!");
	    }
	 

	    @GetMapping
	    public ResponseEntity<List<Book>> getAllBooks() {
	        List<Book> books = bookService.getAllBooks();
	        return ResponseEntity.ok(books);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
	        Book book = bookService.getBookById(id);
	        return ResponseEntity.ok(book);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
	        bookService.updateBook(id, book);
	        return ResponseEntity.ok("Book updated successfully!");
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
	        bookService.deleteBook(id);
	        return ResponseEntity.ok("Book deleted successfully!");
	    }
	    
	    // Exit Application Endpoint
	    

	    @PostMapping("/exit")
	    public ResponseEntity<String> exitApplication() {
	        System.out.println("Shutting down application...");
	        new Thread(() -> {
	            try {
	                Thread.sleep(2000);
	                System.exit(0);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }).start();
	        return ResponseEntity.ok("Application is shutting down...");
	    }
	 
}
