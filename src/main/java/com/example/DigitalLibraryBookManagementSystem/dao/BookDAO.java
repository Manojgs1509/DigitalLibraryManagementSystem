package com.example.DigitalLibraryBookManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import com.example.DigitalLibraryBookManagementSystem.pojo.Book;

public interface BookDAO {

	void addBook(Book book);
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
//    Optional<Book> getBookByTitle(String title);
    void updateBook(Long id,Book book);
    void deleteBook(Long id);
}
