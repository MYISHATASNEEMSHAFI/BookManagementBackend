package com.ty.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "book_id", unique = true)
    private String bookId; // Custom ID like B-001, B-002

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be under 100 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(max = 50, message = "Author must be under 50 characters")
    private String author;

    @NotNull(message = "Publication date is required")
    private LocalDate publicationDate;

    @NotNull(message = "ISBN is required")
    @Pattern(regexp = "\\d{13}", message = "ISBN must be 13 digits")
    private String isbn;

    @NotBlank(message = "Genre is required")
    private String genre;

    @Min(value = 1, message = "Minimum rating is 1")
    @Max(value = 5, message = "Maximum rating is 5")
    private int rating;

    // Default constructor
    public Book() {}

    // Constructor without ID (used when creating a new book)
    public Book(String title, String author, LocalDate publicationDate,
                String isbn, String genre, int rating) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.genre = genre;
        this.rating = rating;
    }

    // Getters and Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public LocalDate getPublicationDate() { return publicationDate; }
    public void setPublicationDate(LocalDate publicationDate) { this.publicationDate = publicationDate; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
