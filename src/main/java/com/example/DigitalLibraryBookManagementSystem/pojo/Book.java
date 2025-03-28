package com.example.DigitalLibraryBookManagementSystem.pojo;

import lombok.Data;

@Data
public class Book {


    private Long id;  // Auto-increment Book ID
    
    private String title;  // Book Title
    
    private String author;  // Author Name
    
    private String genre;  // Book Genre
    
    private String availabilityStatus;  // Available or Checked Out
}
