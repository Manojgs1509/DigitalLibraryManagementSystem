package com.example.DigitalLibraryBookManagementSystem.exception;

public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9077190121924038101L;

	public BookNotFoundException(String message) {
        super(message);
    }
}
