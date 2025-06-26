package com.ty.service;

import com.ty.dto.Book;
import com.ty.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        // Save first to get auto-generated ID
        Book savedBook = bookRepository.save(book);

        // Generate custom bookId: B-001, B-002, etc.
        String customBookId = String.format("B-%03d", savedBook.getId());
        savedBook.setBookId(customBookId);

        // Save again with custom bookId
        return bookRepository.save(savedBook);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
    
    @Override
    public Book updateBook (int id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();

            // Update all necessary fields
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPublicationDate(updatedBook.getPublicationDate());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setRating(updatedBook.getRating());

            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book not found with ID: " + id);
        }
    }

}


