package com.example.DigitalLibraryBookManagementSystem.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.DigitalLibraryBookManagementSystem.dao.BookDAO;
import com.example.DigitalLibraryBookManagementSystem.pojo.Book;


@Repository
public class BookDAoImpl implements BookDAO {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public BookDAoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}

	@Override
	public void addBook(Book book) {
		
		String sql = "INSERT INTO books (title, author, genre, availability_status) " +
				"VALUES (:title, :author, :genre, :availabilityStatus)";

		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("title", book.getTitle())
				.addValue("author", book.getAuthor())
				.addValue("genre", book.getGenre())
				.addValue("availabilityStatus", book.getAvailabilityStatus());

		namedParameterJdbcTemplate.update(sql, params);

	}

	@Override
	public List<Book> getAllBooks() {

		String sql = "SELECT * FROM books";
        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		
		 String sql = "SELECT * FROM books WHERE id = :id";
	        MapSqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
	        List<Book> books = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Book.class));

	        return books.stream().findFirst();
	}

//	@Override
//	public Optional<Book> getBookByTitle(String title) {
//
//         
//	}

	@Override
	public void updateBook(Long id,Book book) {


		String sql = "UPDATE books SET title = :title, author = :author, genre = :genre, " +
                "availability_status = :availabilityStatus WHERE id = :id";

   MapSqlParameterSource params = new MapSqlParameterSource()
		   .addValue("id",id)  
	        .addValue("title", book.getTitle())
	        .addValue("author", book.getAuthor())
	        .addValue("genre", book.getGenre())
	        .addValue("availabilityStatus", book.getAvailabilityStatus());

         namedParameterJdbcTemplate.update(sql, params);
		
	}

	@Override
	public void deleteBook(Long id) {
		  String sql = "DELETE FROM books WHERE id = :id";
	        MapSqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
	        namedParameterJdbcTemplate.update(sql, params);
	}

}
